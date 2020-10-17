package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.dominio.Veiculo;
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
            sb.append("Código: " + veiculo.getCodigo() + "\n");
            sb.append("Fabricante: " + veiculo.getFabricante() + "\n");
            sb.append("Modelo: " + veiculo.getModelo() + " " + veiculo.getAnoModelo() +"\n");
            sb.append("Ano de Fabricação: " + veiculo.getAnoFabricacao() + "\n");
            sb.append("Valor: R$" + veiculo.getValor() + "\n");

            System.out.println(sb);
        }

        em.close();
        JpaUtil.close();
    }
}