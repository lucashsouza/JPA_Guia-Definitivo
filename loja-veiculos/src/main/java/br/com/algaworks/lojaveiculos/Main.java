package br.com.algaworks.lojaveiculos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory(
                "loja-veiculos");
        entityManagerFactory.close();
    }
}
