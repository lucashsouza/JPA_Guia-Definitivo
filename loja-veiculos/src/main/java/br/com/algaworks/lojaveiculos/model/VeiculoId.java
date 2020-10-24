package br.com.algaworks.lojaveiculos.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VeiculoId implements Serializable {
    private String placa;
    private String cidade;

    public VeiculoId() {
    }

    public VeiculoId(String placa, String cidade) {
        super();
        this.placa = placa;
        this.cidade = cidade;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VeiculoId veiculoId = (VeiculoId) o;

        if (!getPlaca().equals(veiculoId.getPlaca())) return false;
        return getCidade().equals(veiculoId.getCidade());
    }

    @Override
    public int hashCode() {
        int result = getPlaca().hashCode();
        result = 31 * result + getCidade().hashCode();
        return result;
    }
}
