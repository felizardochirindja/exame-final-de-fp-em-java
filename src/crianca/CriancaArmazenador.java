package crianca;

import crianca.entidades.Crianca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class CriancaArmazenador {
    public void criar(Crianca crianca) {
        List<Crianca> criancas = listar();
        criancas.add(crianca);

        try {
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\felizardo_chirindja\\ficheiros\\criancas.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(criancas);

            ficheiro.flush();
            ficheiro.close();
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actualizar(String codigo, Crianca crianca) {
        List<Crianca> criancas = listar();

        for (Crianca criancaDaLista: criancas) {
            if (criancaDaLista.getCodigo().equals(codigo)) {
                criancaDaLista.atribuirNome(crianca.getNome());
                criancaDaLista.setSexo(crianca.getSexo());
                criancaDaLista.atribuirParente(crianca.getParente());
                criancaDaLista.setDataDeNascimento(crianca.getDataDeNascimento());
                criancaDaLista.atribuirCodigo(codigo);
                criancaDaLista.setApelido(crianca.getApelido());
                criancaDaLista.desfazerDelecao();

                if (!criancaDaLista.recebeuPrenda()) {
                    try {
                        criancaDaLista.receberPrenda(crianca.getPrenda());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        try {
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\felizardo_chirindja\\ficheiros\\criancas.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(criancas);

            ficheiro.flush();
            ficheiro.close();
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Crianca> listar() {
        List<Crianca> criancas = new ArrayList<>();

        try {
            FileInputStream ficheiro = new FileInputStream("C:\\xampp\\htdocs\\my_space\\java\\felizardo_chirindja\\ficheiros\\criancas.dat");
            ObjectInputStream objecto = new ObjectInputStream(ficheiro);

            criancas = (ArrayList<Crianca>) objecto.readObject();

            ficheiro.close();
            objecto.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
        } catch (Exception e){
            e.printStackTrace();
        }

        // logica para inverter a ordem

        return criancas;
    }

    public Crianca lerPorId(String id) {
        List<Crianca> criancas = listar();

        Crianca crianca = null;

        for (Crianca value: criancas) {
            if (value.getCodigo().equals(id)) {
                crianca = value;
            }
        }

        try {
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\felizardo_chirindja\\ficheiros\\criancas.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(criancas);

            ficheiro.flush();
            ficheiro.close();
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
        } catch (Exception e){
            e.printStackTrace();
        }

        return crianca;
    }

    public void deletar(String id) {
        List<Crianca> criancas = listar();

        for (Crianca crianca : criancas) {
            if (crianca.getCodigo().equals(id)) {
                crianca.deletar();
                System.out.println(crianca);
            }
        }

        try {
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\felizardo_chirindja\\ficheiros\\criancas.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(criancas);

            ficheiro.flush();
            ficheiro.close();
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
