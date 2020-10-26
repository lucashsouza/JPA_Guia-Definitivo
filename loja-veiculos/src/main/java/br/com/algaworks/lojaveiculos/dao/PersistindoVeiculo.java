package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Proprietario;
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

        StringBuilder especificacoes = new StringBuilder();
        especificacoes.append("Carro em excelente estado.\n");
        especificacoes.append("Completo, menos ar.\n");
        especificacoes.append("Primeiro dono, com manual de instrução ");
        especificacoes.append("e todas as revisões feitas.\n");
        especificacoes.append("IPVA pago, aceita financiamento.");

        Proprietario proprietario = new Proprietario();
        proprietario.setNome("João");
        proprietario.setTelefone("(31) 91234-5678");

        // Persistencia na tabela "proprietario"
        em.persist(proprietario);

        Veiculo veiculo = new Veiculo();
        veiculo.setCodigo(new VeiculoId("DDD-4444", "Jundiaí-SP"));
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));
        veiculo.setTipoCombustivel(TipoCombustivel.GASOLINA);
        veiculo.setDataCadastro(new Date());
        veiculo.setEspecificacoes(especificacoes.toString());
        veiculo.setProprietario(proprietario);

        // Persistencia na tabela "tab_veiculo"
        em.persist(veiculo);

        // Commit para efetuar transação
        et.commit();

        em.close();
        JpaUtil.close();
    }
}