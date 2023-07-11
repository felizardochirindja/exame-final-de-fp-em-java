package crianca.telas.cadastro_da_crianca;

import crianca.tipos.Sexo;

import javax.swing.*;
import java.awt.*;

public final class FormularioDosDadosDaCrianca extends JPanel {
    private JLabel labelNome = new JLabel("nome");
    public JTextField campoNome = new JTextField(20);

    private JLabel labelApelido = new JLabel("apelido");
    public JTextField campoApelido = new JTextField(20);

    private JLabel labelSexo = new JLabel("sexo");
    private JRadioButton radioButtonSexoMasculino = new JRadioButton("Masculino");
    private JRadioButton radioButtonSexoFemenino = new JRadioButton("Femenino");

    private JLabel labeldataDeNascimento = new JLabel("data de nascimento");
    public JTextField campoDataDeNascimento = new JTextField(20);

    public FormularioDosDadosDaCrianca() {
        setLayout(new GridLayout(6, 2, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(labelNome);
        add(campoNome);

        add(labelApelido);
        add(campoApelido);

        ButtonGroup buttonGroupSexo = new ButtonGroup();
        buttonGroupSexo.add(radioButtonSexoMasculino);
        buttonGroupSexo.add(radioButtonSexoFemenino);
        add(labelSexo);
        add(new JLabel());
        add(radioButtonSexoMasculino);
        add(radioButtonSexoFemenino);

        add(labeldataDeNascimento);
        add(campoDataDeNascimento);
    }

    public String getSexo() {
        if (radioButtonSexoFemenino.isSelected()) {
            return radioButtonSexoFemenino.getText();
        }

        if (radioButtonSexoMasculino.isSelected()) {
            return radioButtonSexoMasculino.getText();
        }

        return null;
    }

    public void setSexo(Sexo sexo) {
        if (sexo == Sexo.Masculino) {
            radioButtonSexoMasculino.setSelected(true);
        }

        if (sexo == Sexo.Femenino) {
            radioButtonSexoFemenino.setSelected(true);
        }
    }
}
