package crianca.telas.cadastro_da_crianca;

import javax.swing.*;
import java.awt.*;

public final class FormularioDosDadosDoParente extends JPanel {
    private JLabel labelNome = new JLabel("nome");
    public JTextField campoNome = new JTextField(20);

    private JLabel labelApelido = new JLabel("apelido");
    public JTextField campoApelido = new JTextField(20);

    private JLabel labelParentesco = new JLabel("parentesco");
    public JComboBox<String> comboBoxParentesco = new JComboBox<>();

    public JButton botaoRegistrar = new JButton("registrar");

    public FormularioDosDadosDoParente() {
        setLayout(new GridLayout(6, 2, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(labelNome);
        add(campoNome);

        add(labelApelido);
        add(campoApelido);

        DefaultComboBoxModel<String> modeloDoComboboxParentesco = new DefaultComboBoxModel<>();
        modeloDoComboboxParentesco.addElement("Pai");
        modeloDoComboboxParentesco.addElement("Mae");
        comboBoxParentesco.setModel(modeloDoComboboxParentesco);

        add(labelParentesco);
        add(comboBoxParentesco);

        add(new JLabel());
        add(botaoRegistrar);
    }
}
