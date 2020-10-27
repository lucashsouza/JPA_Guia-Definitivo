package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Proprietario;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;

public class ConsultandoProprietario {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Proprietario proprietario = em.find(Proprietario.class, 1L);

        System.out.println(proprietario.getNome() + " - "
                + proprietario.getTelefone());

        em.close();
        JpaUtil.close();
    }
}
