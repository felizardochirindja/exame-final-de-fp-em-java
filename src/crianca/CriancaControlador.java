package crianca;

import crianca.entidades.Crianca;
import crianca.entidades.Parente;
import crianca.telas.TelaListarCriancasComPrenda;
import crianca.telas.TelaNotificacaoDoRecebimentoDaPrenda;
import crianca.telas.cadastro_da_crianca.TelaCadastrarCrianca;
import crianca.telas.TelaListarCriancas;
import crianca.tipos.Parentesco;
import crianca.tipos.Prenda;
import crianca.tipos.Sexo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public final class CriancaControlador {
    HashMap<Integer, Crianca> criancasDaTabela = new HashMap<>();

    public CriancaControlador(TelaCadastrarCrianca tela, CriancaAcionador acionador, Crianca crianca) {
        if (crianca != null) {
            tela.formularioDosDadosDoParente.botaoRegistrar.setText("actualizar");

            tela.formularioDosDadosDaCrianca.campoApelido.setText("teste");
            tela.formularioDosDadosDaCrianca.campoNome.setText(crianca.getNome());
            tela.formularioDosDadosDaCrianca.setSexo(crianca.getSexo());
            tela.formularioDosDadosDaCrianca.campoDataDeNascimento.setText("05/04/2000");

            tela.formularioDosDadosDoParente.campoNome.setText(crianca.getParente().getNome());
            tela.formularioDosDadosDoParente.campoApelido.setText("teste");

            String parentesco = String.valueOf(Parentesco.valueOf(crianca.getParente().getParentesco().toString()));
            tela.formularioDosDadosDoParente.comboBoxParentesco.setSelectedItem(parentesco);
        }

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

                Parente parente = new Parente(nomeDoParente, apelidoDoParente, parentesco);
                Crianca criancaQueSeraRegistrada = new Crianca(nomeDaCrianca, apelidoDaCrianca, dataDeNascimento, sexoDaCrianca, parente);

                if (crianca != null) {
                    try {
                        acionador.actualizarCrianca(crianca.getCodigo(), criancaQueSeraRegistrada);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    acionador.cadastrarCrianca(criancaQueSeraRegistrada);
                }

                tela.dispose();
            }
        });
    }

    public CriancaControlador(TelaListarCriancas tela, CriancaAcionador acionador, boolean listarTodas) {
        List<Crianca> criancas;

        if (listarTodas) {
            criancas = acionador.listarTodasCriancas();
        } else {
            criancas = acionador.pesquisarCriancasAbaixoDeDezAnosSemPrenda();
        }

        for (int i = 0; i < criancas.size(); i++) {
            Object[] linhaDaTabela = {
                criancas.get(i).getNome(),
                criancas.get(i).calcularIdade(),
                criancas.get(i).getSexo(),
                criancas.get(i).getParente().getNome(),
                criancas.get(i).getParente().getParentesco(),
            };

            tela.modeloDaTabela.addRow(linhaDaTabela);
            criancasDaTabela.put(i, criancas.get(i));
        }

        tela.tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = tela.tabela.rowAtPoint(e.getPoint());

                    if (row >= 0 && row < tela.tabela.getRowCount()) {
                        tela.tabela.setRowSelectionInterval(row, row);

                        int linhaSelecionada = tela.tabela.getSelectedRow();
                        Crianca criancaSelecionada = criancasDaTabela.get(linhaSelecionada);

                        JPopupMenu popupMenu = new JPopupMenu();
                        // menu oferecer prenda
                        JMenuItem menuItemOferecerPrenda = new JMenuItem("oferecer prenda");
                        menuItemOferecerPrenda.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Prenda prendaOferecida = acionador.receberPrenda(criancaSelecionada.getCodigo());

                                new TelaNotificacaoDoRecebimentoDaPrenda(criancaSelecionada.getNome(), criancaSelecionada.calcularIdade().toString(), prendaOferecida.toString());

                                tela.dispose();
                            }
                        });

                        if (!criancaSelecionada.recebeuPrenda()) {
                            popupMenu.add(menuItemOferecerPrenda);
                        }

                        // menu actualizar
                        JMenuItem menuItemActualizar = new JMenuItem("actualizar");
                        menuItemActualizar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                tela.dispose();
                                new CriancaControlador(new TelaCadastrarCrianca(), new CriancaAcionador(new CriancaArmazenador()), criancaSelecionada);
                            }
                        });
                        popupMenu.add(menuItemActualizar);

                        // menu deletar
                        JMenuItem menuItemDeletar = new JMenuItem("deletar");
                        menuItemDeletar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(criancaSelecionada);
                                acionador.removerCrianca(criancaSelecionada.getCodigo());
                                tela.dispose();
                                new CriancaControlador(new TelaListarCriancas(), new CriancaAcionador(new CriancaArmazenador()), listarTodas);
                            }
                        });
                        popupMenu.add(menuItemDeletar);

                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });
    }

    public CriancaControlador(TelaListarCriancasComPrenda tela, CriancaAcionador acionador) {
        List<Crianca> criancas = acionador.listarCriancasQueReceberamPrenda();

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
}
