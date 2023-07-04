package crianca;

import crianca.entidades.Crianca;
import crianca.entidades.Parente;
import crianca.telas.TelaContarPrendasOferecidas;
import crianca.telas.TelaListarCriancasAbaixoDeDezAnosSemPrenda;
import crianca.telas.cadastro_da_crianca.TelaCadastrarCrianca;
import crianca.telas.TelaListarCriancas;
import crianca.tipos.Parentesco;
import crianca.tipos.Sexo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CriancaControlador {
    public CriancaControlador(TelaCadastrarCrianca tela, CriancaAccoes accoes) {
        tela.formularioDosDadosDoParente.botaoRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parente parente = new Parente("parente", Parentesco.valueOf("mae"));
                Crianca crianca = new Crianca("crianca", null, Sexo.Masculino, parente);

                accoes.cadastrarCrianca(crianca);
            }
        });
    }

    public CriancaControlador(TelaListarCriancas tela, CriancaAccoes accoes) {
        List<Crianca> criancas = accoes.listarTodasCriancas();

        for (int i = 0; i < criancas.size(); i++) {
            Object[] linhaDaTabela = {
                    criancas.get(i).getNome(),
                    criancas.get(i).calcularIdade(),
                    criancas.get(i).getSexo(),
                    criancas.get(i).getParente().getNome(),
                    criancas.get(i).getPrenda(),
            };

            tela.modeloDaTabela.addRow(linhaDaTabela);
        }
    }

    public CriancaControlador(TelaListarCriancasAbaixoDeDezAnosSemPrenda tela, CriancaAccoes accoes) {
        List<Crianca> criancas = accoes.listarTodasCriancas();

        for (int i = 0; i < criancas.size(); i++) {
            Object[] linhaDaTabela = {
                    criancas.get(i).getNome(),
                    criancas.get(i).calcularIdade(),
                    criancas.get(i).getSexo(),
                    criancas.get(i).getParente().getNome(),
                    criancas.get(i).getPrenda(),
            };

            tela.modeloDaTabela.addRow(linhaDaTabela);
        }
    }

    public CriancaControlador(TelaContarPrendasOferecidas tela, CriancaAccoes accoes) {
        int numeroDeBonecas = accoes.contarBonecasOferecidas();
        int numeroDeCarrinhos = accoes.contarCarrinhosOferecidos();
    }
}
