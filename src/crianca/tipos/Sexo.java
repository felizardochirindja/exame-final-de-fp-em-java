package crianca.tipos;

import java.io.Serializable;

public enum Sexo implements Serializable {
    Masculino("masculino"),
    Femenino("femenino");

    String valor;

    Sexo(String valor) {
        this.valor = valor;
    }
}
