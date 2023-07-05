package crianca.telas;
import javax.swing.*;
import java.awt.*;

public class TelaListarCriancasAbaixoDeDezAnosSemPrenda extends JFrame {
    public TelaListarCriancasAbaixoDeDezAnosSemPrenda() {
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        setTitle("contagem das prendas oferecidas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
