package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ConsultandoVeiculos {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Veiculo> veiculos = em
                .createQuery("select v from Veiculo v", Veiculo.class)
                .getResultList();

        veiculos.forEach(veiculo -> {
            System.out.println(veiculo.getModelo() + " - "
                    + veiculo.getProprietario().getNome());
        });

        em.close();
        JpaUtil.close();
    }
}
