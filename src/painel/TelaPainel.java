package painel;

import crianca.*;
import crianca.telas.TelaListarCriancasComPrenda;
import crianca.telas.cadastro_da_crianca.TelaCadastrarCrianca;
import crianca.telas.TelaListarCriancas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class TelaPainel extends JFrame {
    private JButton botaoRegistrarCrianca = new JButton("registrar crianca");
    private JButton botaoListarCriancas = new JButton("listar criancas");
    private JButton botaoListarCriancasComPrenda = new JButton("listar criancas que receberam prenda");
    private JButton botaoContarPrendasOferecidas = new JButton("contar prendas oferecidas");
    private JButton botaoListarCriancasAbaixoDeDezAnosSemPrenda = new JButton("listar criancas abaixo de dez anos sem prenda");

    public TelaPainel() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(2, 1, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        botaoRegistrarCrianca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaCadastrarCrianca(), new CriancaAcionador(new CriancaArmazenador()), null);
            }
        });

        painel.add(botaoRegistrarCrianca);

        botaoListarCriancas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaListarCriancas(), new CriancaAcionador(new CriancaArmazenador()), true);
            }
        });

        painel.add(botaoListarCriancas);

        botaoListarCriancasComPrenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaListarCriancasComPrenda(), new CriancaAcionador(new CriancaArmazenador()));
            }
        });

        painel.add(botaoListarCriancasComPrenda);

        botaoContarPrendasOferecidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CriancaAcionador accoes = new CriancaAcionador(new CriancaArmazenador());

                int numeroDeBonecas = accoes.contarBonecasOferecidas();
                int numeroDeCarrinhos = accoes.contarCarrinhosOferecidos();

                JOptionPane.showMessageDialog(null, "O numero de bonecas atribuidas foi: " + numeroDeBonecas + " e o numero de carrinhos atribuidos foi: " + numeroDeCarrinhos);
            }
        });

        painel.add(botaoContarPrendasOferecidas);

        botaoListarCriancasAbaixoDeDezAnosSemPrenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriancaControlador(new TelaListarCriancas(), new CriancaAcionador(new CriancaArmazenador()), false);
            }
        });

        painel.add(botaoListarCriancasAbaixoDeDezAnosSemPrenda);

        add(painel);

        setTitle("painel do administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
