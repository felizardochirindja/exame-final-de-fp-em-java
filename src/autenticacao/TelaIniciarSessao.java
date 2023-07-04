package autenticacao;

import painel.TelaPainel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaIniciarSessao extends JFrame {
    private JLabel labelUsuaio = new JLabel("usuario *");
    private JTextField campoUsuario = new JTextField(10);

    private JLabel labelPalavraPasse = new JLabel("palavra-passe *");
    private JPasswordField campoPalavraPasse = new JPasswordField(10);;

    private JButton botaoCancelar = new JButton("cancelar");
    private JButton botaoEntrar = new JButton("entrar");

    public TelaIniciarSessao() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(labelUsuaio);
        panel.add(campoUsuario);

        panel.add(labelPalavraPasse);
        panel.add(campoPalavraPasse);

        panel.add(botaoCancelar);
        panel.add(botaoEntrar);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoUsuario.getText().equals(String.valueOf(campoPalavraPasse.getPassword()))) {
                    dispose();
                    new TelaPainel();
                } else {
                    JOptionPane.showMessageDialog(null, "credenciais incorrectas!");
                }
            }
        });

        botaoCancelar.addActionListener(e -> dispose());

        add(panel);

        getRootPane().setDefaultButton(botaoEntrar);
        setTitle("Iniciar sessao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 180);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
