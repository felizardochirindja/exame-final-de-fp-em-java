package crianca.tipos;

import java.io.Serializable;

public enum Parentesco implements Serializable {
    Mae("mae"),
    Pai("pai");

    String valor;

    Parentesco(String valor) {
        this.valor = valor;
    }
}
