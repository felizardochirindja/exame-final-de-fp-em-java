package crianca.telas.cadastro_da_crianca;

import javax.swing.*;
import java.awt.*;

public class FormularioDosDadosDoParente extends JPanel {
    private JLabel labelNome = new JLabel("nome");
    public JTextField campoNome = new JTextField(20);

    private JLabel labelApelido = new JLabel("apelido");
    public JTextField campoApelido = new JTextField(20);

    private JLabel labelSexo = new JLabel("sexo");
    public JComboBox<String> campoSexo;

    private JLabel labeldataDeNascimento = new JLabel("data de nascimento");
    public JTextField campoDataDeNascimento = new JTextField(20);

    public JButton botaoRegistrar = new JButton("registrar");

    public FormularioDosDadosDoParente() {
        setLayout(new GridLayout(6, 2, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(labelNome);
        add(campoNome);

        add(labelApelido);
        add(campoApelido);

        add(labelSexo);
        add(campoNome);

        add(labeldataDeNascimento);
        add(campoDataDeNascimento);

        add(new JLabel());
        add(botaoRegistrar);
    }
}
