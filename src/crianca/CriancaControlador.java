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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CriancaControlador {
    public CriancaControlador(TelaCadastrarCrianca tela, CriancaAcionador acionador) {
        tela.formularioDosDadosDoParente.botaoRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dados da crianca
                String nomeDaCrianca = tela.formularioDosDadosDaCrianca.campoNome.getText();
                String apelidoDaCrianca = tela.formularioDosDadosDaCrianca.campoApelido.getText();
                Sexo sexoDaCrianca = Sexo.valueOf(tela.formularioDosDadosDaCrianca.getSexo());

                String textoDataDeNascimento = tela.formularioDosDadosDaCrianca.campoDataDeNascimento.getText();
                Date dataDeNascimento;
                try {
                    dataDeNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(textoDataDeNascimento);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                // dados do patente
                String nomeDoParente = tela.formularioDosDadosDoParente.campoNome.getText();
                String apelidoDoParente = tela.formularioDosDadosDoParente.campoApelido.getText();
                Parentesco parentesco = Parentesco.valueOf(tela.formularioDosDadosDoParente.comboBoxParentesco.getSelectedItem().toString());

                Parente parente = new Parente(nomeDoParente, parentesco);
                Crianca crianca = new Crianca(nomeDaCrianca, dataDeNascimento, sexoDaCrianca, parente);

                acionador.cadastrarCrianca(crianca);
            }
        });
    }

    public CriancaControlador(TelaListarCriancas tela, CriancaAcionador acionador) {
        List<Crianca> criancas = acionador.listarTodasCriancas();

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

    public CriancaControlador(TelaListarCriancasAbaixoDeDezAnosSemPrenda tela, CriancaAcionador acionador) {
        List<Crianca> criancas = acionador.listarTodasCriancas();

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

    public CriancaControlador(TelaContarPrendasOferecidas tela, CriancaAcionador acionador) {
        int numeroDeBonecas = acionador.contarBonecasOferecidas();
        int numeroDeCarrinhos = acionador.contarCarrinhosOferecidos();
    }
}
