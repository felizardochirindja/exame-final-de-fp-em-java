package crianca.entidades;

import crianca.tipos.Prenda;
import crianca.tipos.Sexo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public final class Crianca implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private String codigo;
    private String nome;
    private String apelido;
    private Date dataDeNascimento;
    private Sexo sexo;
    private Parente parente;
    private Prenda prenda;
    private boolean removida;

    public Crianca(String nome, String apelido, Date dataDeNascimento, Sexo sexo, Parente parente) {
        this.nome = nome;
        this.apelido = apelido;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.parente = parente;
        this.removida = false;
    }

    public void atribuirCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Parente getParente() {
        return parente;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public boolean recebeuPrenda() {
        return prenda != null;
    }

    public void receberPrenda(Prenda prenda) throws Exception {
        if (this.prenda != null) {
            throw new Exception("crianca ja recebeu prenda");
        }

        if (sexo == Sexo.Masculino && prenda == Prenda.Boneca) {
            throw new Exception("um menino nao pode receber uma boneca");
        }

        if (sexo == Sexo.Femenino && prenda == Prenda.Carrinho) {
            throw new Exception("uma menina nao pode receber um carrinho");
        }

        this.prenda = prenda;
    }

    public void atribuirNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void atribuirParente(Parente parente) {
        this.parente = parente;
    }

    public boolean foiRemovida() {
        return removida;
    }

    public void deletar() {
        this.removida = true;
    }

    public void desfazerDelecao() {
        this.removida = false;
    }

    public Long calcularIdade() {
        Long idade = ChronoUnit.YEARS.between(
            dataDeNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            LocalDate.now()
        );

        return idade;
    }

    @Override
    public String toString() {
        return "Crianca{" +
            "codigo='" + codigo + '\'' +
            ", nome='" + nome + '\'' +
            ", dataDeNascimento=" + dataDeNascimento +
            ", sexo=" + sexo +
            ", parente=" + parente +
            ", prenda=" + prenda +
            ", removida=" + removida +
        '}';
    }
}
