package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.dominio.Veiculo;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class PersistindoVeiculo {
    public static void main(String[] args) {
        // Gerencia o ciclo de vida das entidades
        EntityManager em = JpaUtil.getEntityManager();

        // Inicio da transacao
        EntityTransaction et = em.getTransaction();
        et.begin();

        Veiculo veiculo = new Veiculo();
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));

        // Persistencia no banco de dados
        em.persist(veiculo);

        // Commit para efetuar transação
        et.commit();

        em.close();
        JpaUtil.close();
    }
}