package crianca.telas;

import javax.swing.*;
import java.awt.*;

public final class TelaNotificacaoDoRecebimentoDaPrenda extends JFrame {
    private JLabel labelNome = new JLabel("nome:");
    private JLabel labelTextoNome = new JLabel();

    private JLabel labelIdade = new JLabel("idade:");
    private JLabel labelTextoIdade = new JLabel();

    private JLabel labelPrenda = new JLabel("prenda: ");
    private JLabel labelTextoPrenda = new JLabel();

    public TelaNotificacaoDoRecebimentoDaPrenda(String nome, String idade, String prenda) {
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setLayout(new GridLayout(3, 2, 5, 5));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        labelTextoNome.setText(nome);
        labelTextoIdade.setText(idade);
        labelTextoPrenda.setText(prenda);

        painelPrincipal.add(labelNome);
        painelPrincipal.add(labelTextoNome);
        painelPrincipal.add(labelIdade);
        painelPrincipal.add(labelTextoIdade);
        painelPrincipal.add(labelPrenda);
        painelPrincipal.add(labelTextoPrenda);

        add(painelPrincipal);

        setTitle("");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
