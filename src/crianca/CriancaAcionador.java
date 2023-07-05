package crianca;

import crianca.entidades.Crianca;
import crianca.tipos.Prenda;
import crianca.tipos.Sexo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CriancaAcionador {
    private CriancaArmazenador armazenador;

    public CriancaAcionador(CriancaArmazenador armazenador) {
        this.armazenador = armazenador;
    }

    public List<Crianca> listarTodasCriancas() {
        List<Crianca> todasCriancas = armazenador.listar();
        List<Crianca> criancas = new ArrayList<>();

        for (int i = 0; i < todasCriancas.size(); i++) {
            if (!todasCriancas.get(i).foiRemovida()) {
                criancas.add(todasCriancas.get(i));
            }
        }

        return criancas;
    }

    public void cadastrarCrianca(Crianca crianca) {
        crianca.atribuirCodigo(UUID.randomUUID().toString());
        armazenador.criar(crianca);
    }

    public void removerCrianca(String id) {
        armazenador.deletar(id);
    }

    public void actualizarCrianca(String id, Crianca crianca) {
        armazenador.actualizar(id, crianca);
    }

    public List<Crianca> listarCriancasQueReceberamPrenda() {
        List<Crianca> todasCriancas = armazenador.listar();
        List<Crianca> criancas = new ArrayList<>();

        for (int i = 0; i < todasCriancas.size(); i++) {
            if (todasCriancas.get(i).recebeuPrenda() && !todasCriancas.get(i).foiRemovida()) {
                criancas.add(todasCriancas.get(i));
            }
        }

        return criancas;
    }

    public void receberPrenda(String id) {
        Crianca crianca = armazenador.lerPorId(id);

        Prenda prenda = Prenda.Carrinho;

        if (crianca.getSexo() == Sexo.Femenino) {
            prenda = Prenda.Boneca;
        }

        try {
            crianca.receberPrenda(prenda);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        armazenador.actualizar(id, crianca);
    }

    public List<Crianca> pesquisarCriancasAbaixoDeDezAnosSemPrenda() {
        List<Crianca> criancas = armazenador.listar();

        for (int i = 0; i < criancas.size(); i++) {
            if (criancas.get(i).foiRemovida() || !criancas.get(i).recebeuPrenda() || criancas.get(i).calcularIdade() > 10) {
                criancas.remove(i);
            }
        }

        return criancas;
    }

    public int contarCarrinhosOferecidos() {
        List<Crianca> criancasReceberamPrenda = armazenador.listar();

        int numeroDeCarrinhosOferecidos = 0;

        for (Crianca crianca: criancasReceberamPrenda) {
            if (crianca.getPrenda() == Prenda.Carrinho) {
                numeroDeCarrinhosOferecidos++;
            }
        }

        return numeroDeCarrinhosOferecidos;
    }

    public int contarBonecasOferecidas() {
        List<Crianca> criancasQueReceberamPrenda = armazenador.listar();

        int numeroBonecasOferecidas = 0;

        for (Crianca crianca: criancasQueReceberamPrenda) {
            if (crianca.getPrenda() == Prenda.Boneca) {
                numeroBonecasOferecidas++;
            }
        }

        return  numeroBonecasOferecidas;
    }
}
