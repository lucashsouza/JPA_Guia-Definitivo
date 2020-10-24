package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ExcluindoVeiculo {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Veiculo veiculo = em.find(Veiculo.class, 1L);
        em.remove(veiculo);

        et.commit();
        em.close();
        JpaUtil.close();
    }
}