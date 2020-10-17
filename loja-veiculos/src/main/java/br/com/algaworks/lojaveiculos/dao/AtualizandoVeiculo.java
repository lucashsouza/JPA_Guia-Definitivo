package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.dominio.Veiculo;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class AtualizandoVeiculo {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Veiculo veiculo = em.find(Veiculo.class, 1L);

        System.out.println("Valor atual: " + veiculo.getValor());
        veiculo.setValor(veiculo.getValor().subtract(new BigDecimal(500)));
        System.out.println("Novo valor com desconto: " + veiculo.getValor());

        et.commit();
        em.close();
        JpaUtil.close();
    }
}
