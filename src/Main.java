import crianca.CriancaAccoes;
import crianca.CriancaArmazenador;
import crianca.CriancaControlador;
import crianca.telas.cadastro_da_crianca.TelaCadastrarCrianca;

public class Main {
    public static void main(String[] args) {
//        new TelaIniciarSessao();
//        new TelaCadastrarCrianca();
        new CriancaControlador(new TelaCadastrarCrianca(), new CriancaAccoes(new CriancaArmazenador()));
    }
}