package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.model.VeiculoId;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;

public class BuscandoVeiculo2 {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        VeiculoId codigo = new VeiculoId("AAA-1111", "São Paulo - SP");
        Veiculo veiculo = em.getReference(Veiculo.class, codigo);

        StringBuilder sb = new StringBuilder();
        sb.append("============================\n");
        sb.append("\tConsulta de veiculos\t\n");
        sb.append("============================\n");
        sb.append("Placa: " + veiculo.getCodigo().getPlaca() + "\n");
        sb.append("Cidade: " + veiculo.getCodigo().getCidade() + "\n");
        sb.append("Modelo: " + veiculo.getModelo() + "\n");
        sb.append("\nEspeficicações: " + veiculo.getEspecificacoes() + "\n");
        sb.append("Proprietário: " + veiculo.getProprietario().getNome() + "\n");
        sb.append("Telefone: " + veiculo.getProprietario().getTelefone() + "\n");
        sb.append("============================");

        System.out.println(sb);

        em.close();
        JpaUtil.close();
    }
}