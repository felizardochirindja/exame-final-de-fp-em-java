package crianca.entidades;

import crianca.tipos.Parentesco;

import java.io.Serializable;

public class Parente implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private String codigo;
    private String nome;
    private Parentesco parentesco;

    public Parente(String nome, Parentesco parentesco) {
        this.nome = nome;
        this.parentesco = parentesco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    @Override
    public String toString() {
        return "Parente{" +
                "id='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", sexo='" + parentesco + '\'' +
                '}';
    }
}
