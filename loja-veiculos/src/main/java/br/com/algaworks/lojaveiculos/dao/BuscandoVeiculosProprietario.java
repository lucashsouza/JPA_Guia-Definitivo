package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Proprietario;
import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;


public class BuscandoVeiculosProprietario {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        Proprietario proprietario = em.find(Proprietario.class, 1L);
        System.out.println("Proprietario: " + proprietario.getNome());

        // Listar todos os Veiculos do proprietario
        for (Veiculo veiculo : proprietario.getVeiculos()){
            System.out.println("Veículo: " + veiculo.getModelo());
        }

        em.close();
        JpaUtil.close();
    }
}
