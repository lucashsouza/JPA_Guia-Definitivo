package br.com.algaworks.lojaveiculos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "loja-veiculos");
        entityManagerFactory.close();
    }
}
