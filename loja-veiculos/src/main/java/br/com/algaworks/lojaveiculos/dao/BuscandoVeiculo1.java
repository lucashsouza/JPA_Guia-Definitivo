package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.dominio.Veiculo;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;

public class BuscandoVeiculo1 {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Veiculo veiculo = em.find(Veiculo.class, 1L);

        StringBuilder sb = new StringBuilder();
        sb.append("============================\n");
        sb.append("\tConsulta de veiculos\t\n");
        sb.append("============================\n");
        sb.append("Código do veículo: " + veiculo.getCodigo() + "\n");
        sb.append("Modelo: " + veiculo.getModelo() + "\n");
        sb.append("============================");

        System.out.println(sb);

        em.close();
        JpaUtil.close();
    }
}