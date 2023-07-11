package crianca.entidades;

import crianca.tipos.Parentesco;

import java.io.Serializable;

public final class Parente implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private String codigo;
    private String nome;
    private String apelido;
    private Parentesco parentesco;

    public Parente(String nome, String apelido, Parentesco parentesco) {
        this.nome = nome;
        this.apelido = apelido;
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

    public String getApelido() {
        return apelido;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    @Override
    public String toString() {
        return "Parente{" +
            "codigo='" + codigo + '\'' +
            ", nome='" + nome + '\'' +
            ", apelido='" + apelido + '\'' +
            ", parentesco=" + parentesco +
        '}';
    }
}
