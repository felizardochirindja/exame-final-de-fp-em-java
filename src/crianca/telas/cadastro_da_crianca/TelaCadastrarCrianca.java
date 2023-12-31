package crianca.telas.cadastro_da_crianca;

import javax.swing.*;

public final class TelaCadastrarCrianca extends JFrame {
    public FormularioDosDadosDaCrianca formularioDosDadosDaCrianca = new FormularioDosDadosDaCrianca();
    public FormularioDosDadosDoParente formularioDosDadosDoParente = new FormularioDosDadosDoParente();

    public TelaCadastrarCrianca() {
        JTabbedPane painelPrincipal = new JTabbedPane();

        painelPrincipal.addTab("crianca", formularioDosDadosDaCrianca);
        painelPrincipal.addTab("parente", formularioDosDadosDoParente);

        add(painelPrincipal);

        getRootPane().setDefaultButton(formularioDosDadosDoParente.botaoRegistrar);
        setTitle("registrar estudante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
