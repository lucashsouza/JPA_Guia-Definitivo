package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.TipoCombustivel;
import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.model.VeiculoId;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class PersistindoVeiculo {
    public static void main(String[] args) {
        // Gerencia o ciclo de vida das entidades
        EntityManager em = JpaUtil.getEntityManager();

        // Inicio da transacao
        EntityTransaction et = em.getTransaction();
        et.begin();

        Veiculo veiculo = new Veiculo();
        veiculo.setCodigo(new VeiculoId("DDD-4444", "Jundiaí-SP"));
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));
        veiculo.setTipoCombustivel(TipoCombustivel.GASOLINA);
        veiculo.setDataCadastro(new Date());

        // Persistencia no banco de dados
        em.persist(veiculo);

        // Commit para efetuar transação
        et.commit();

        em.close();
        JpaUtil.close();
    }
}