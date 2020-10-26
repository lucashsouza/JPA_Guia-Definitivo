package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ListandoVeiculos {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Query query = em.createQuery("select v from Veiculo v");
        List<Veiculo> veiculos = query.getResultList();

        for (Veiculo veiculo : veiculos){
            StringBuilder sb = new StringBuilder();
            sb.append("Placa: " + veiculo.getCodigo().getPlaca() + "\n");
            sb.append("Cidade: " + veiculo.getCodigo().getCidade() + "\n");
            sb.append("Fabricante: " + veiculo.getFabricante() + "\n");
            sb.append("Modelo: " + veiculo.getModelo() + " " + veiculo.getAnoModelo() +"\n");
            sb.append("Ano de Fabricação: " + veiculo.getAnoFabricacao() + "\n");
            sb.append("Valor: R$" + veiculo.getValor() + "\n");
            sb.append("Tipo de combustivel: " + veiculo.getTipoCombustivel() + "\n");
            sb.append("Data cadastro: " + veiculo.getDataCadastro() + "\n");
            sb.append("Proprietário: " + veiculo.getProprietario().getNome());
            sb.append(", Telefone: " + veiculo.getProprietario().getTelefone() + "\n");

            System.out.println(sb);
        }

        em.close();
        JpaUtil.close();
    }
}