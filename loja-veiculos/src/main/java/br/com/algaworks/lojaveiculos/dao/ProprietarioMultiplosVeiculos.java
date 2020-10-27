package br.com.algaworks.lojaveiculos.dao;

import br.com.algaworks.lojaveiculos.model.Proprietario;
import br.com.algaworks.lojaveiculos.model.TipoCombustivel;
import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.model.VeiculoId;
import br.com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.util.Date;

public class ProprietarioMultiplosVeiculos {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Proprietario proprietario = new Proprietario();
        proprietario.setNome("Lucas Souza");
        proprietario.setTelefone("(11) 91234-1234");
        em.persist(proprietario);

        Veiculo veiculo1 = new Veiculo();
        veiculo1.setCodigo(new VeiculoId("FFF-5555", "São Paulo-SP"));
        veiculo1.setFabricante("GM");
        veiculo1.setModelo("Celta");
        veiculo1.setAnoFabricacao(2015);
        veiculo1.setAnoModelo(2015);
        veiculo1.setValor(new BigDecimal(11000));
        veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
        veiculo1.setDataCadastro(new Date());
        veiculo1.setProprietario(proprietario);
        em.persist(veiculo1);


        Veiculo veiculo2 = new Veiculo();
        veiculo2.setCodigo(new VeiculoId("GGG-6666", "São Paulo-SP"));
        veiculo2.setFabricante("VW");
        veiculo2.setModelo("Gol");
        veiculo2.setAnoFabricacao(2018);
        veiculo2.setAnoModelo(2018);
        veiculo2.setValor(new BigDecimal(17200));
        veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo2.setDataCadastro(new Date());
        veiculo2.setProprietario(proprietario);
        em.persist(veiculo2);

        et.commit();
        em.close();
        JpaUtil.close();
    }
}
