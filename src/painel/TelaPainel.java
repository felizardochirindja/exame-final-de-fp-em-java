package painel;

import crianca.CriancaAccoes;
import crianca.CriancaArmazenador;
import crianca.CriancaControlador;
import crianca.telas.TelaContarPrendasOferecidas;
import crianca.telas.TelaListarCriancasAbaixoDeDezAnosSemPrenda;
import crianca.telas.cadastro_da_crianca.TelaCadastrarCrianca;
import crianca.telas.TelaListarCriancas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPainel extends JFrame {
    private JButton botaoRegistrarCrianca = new JButton("registrar crianca");
    private JButton botaoListarCriancas = new JButton("listar criancas");
    private JButton botaoContarPrendasOferecidas = new JButton("contar prendas oferecidas");
    private JButton botaoListarCriancasAbaixoDeDezAnosSemPrenda = new JButton("listar criancas abaixo de dez anos sem prenda");

    public TelaPainel() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(2, 1, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        painel.add(botaoRegistrarCrianca);

        botaoRegistrarCrianca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaCadastrarCrianca(), new CriancaAccoes(new CriancaArmazenador()));
            }
        });

        botaoListarCriancas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaListarCriancas(), new CriancaAccoes(new CriancaArmazenador()));
            }
        });

        botaoContarPrendasOferecidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaContarPrendasOferecidas(), new CriancaAccoes(new CriancaArmazenador()));
            }
        });

        botaoListarCriancasAbaixoDeDezAnosSemPrenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaListarCriancasAbaixoDeDezAnosSemPrenda(), new CriancaAccoes(new CriancaArmazenador()));
            }
        });

        painel.add(botaoListarCriancas);

        add(painel);

        setTitle("painel do administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
