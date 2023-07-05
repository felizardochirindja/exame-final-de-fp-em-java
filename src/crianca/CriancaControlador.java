package crianca;

import crianca.entidades.Crianca;
import crianca.entidades.Parente;
import crianca.telas.TelaContarPrendasOferecidas;
import crianca.telas.TelaListarCriancasAbaixoDeDezAnosSemPrenda;
import crianca.telas.cadastro_da_crianca.TelaCadastrarCrianca;
import crianca.telas.TelaListarCriancas;
import crianca.tipos.Parentesco;
import crianca.tipos.Sexo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        tela.tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = tela.tabela.rowAtPoint(e.getPoint());

                    if (row >= 0 && row < tela.tabela.getRowCount()) {
                        JPopupMenu popupMenu = new JPopupMenu();
                        JMenuItem menuItemOferecerPrenda = new JMenuItem("oferecre prenda");
                        JMenuItem menuItemActualizar = new JMenuItem("actualizar");
                        JMenuItem menuItemDeletar = new JMenuItem("deletar");
                        popupMenu.add(menuItemDeletar);
                        popupMenu.add(menuItemOferecerPrenda);
                        popupMenu.add(menuItemActualizar);

                        tela.tabela.setRowSelectionInterval(row, row);
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });
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
