package br.com.algaworks.lojaveiculos.util;
import br.com.algaworks.lojaveiculos.model.TipoCombustivel;
import br.com.algaworks.lojaveiculos.model.Veiculo;
import br.com.algaworks.lojaveiculos.model.VeiculoId;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ExibindoImagem {
    public static void main(String[] args) throws IOException {
        // Lê bytes do arquivo da imagem.
        Path path = FileSystems.getDefault().getPath("src/main/resources/arquivos-extras/Hyundai-ix35.jpg");
        byte[] foto = Files.readAllBytes(path);

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Veiculo veiculo = new Veiculo();
        veiculo.setCodigo(new VeiculoId("EEE-5555", "Jundiaí-SP"));

        veiculo.setFabricante("Hyundai");
        veiculo.setModelo("ix35");
        veiculo.setAnoFabricacao(2019);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(100_000));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(new Date());
        veiculo.setFoto(foto);

        em.persist(veiculo);
        et.commit();
        em.detach(veiculo);

        Veiculo veiculoComImagem = em.find(Veiculo.class, veiculo.getCodigo());

        if (veiculoComImagem.getFoto() != null) {
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(veiculoComImagem.getFoto()));
            JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
        } else {
            System.out.println("Veículo não possui foto.");
        }

        em.close();
        JpaUtil.close();
    }
}