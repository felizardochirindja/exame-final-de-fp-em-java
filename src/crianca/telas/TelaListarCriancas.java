package crianca.telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaListarCriancas extends JFrame {
    public JTable tabela;
    public DefaultTableModel modeloDaTabela = new DefaultTableModel();

    public TelaListarCriancas() {
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        modeloDaTabela.addColumn("nome");
        modeloDaTabela.addColumn("idade");
        modeloDaTabela.addColumn("sexo");
        modeloDaTabela.addColumn("parente");

        tabela = new JTable(modeloDaTabela);
        JScrollPane painelDaTabela = new JScrollPane(tabela);

        painelPrincipal.add(painelDaTabela);

        add(painelPrincipal);

        setTitle("listar criancas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
