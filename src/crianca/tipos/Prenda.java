package crianca.tipos;

import java.io.Serializable;

public enum Prenda implements Serializable {
    Carrinho("carrinho"),
    Boneca("boneca");

    String tipo;

    Prenda(String tipo) {
        this.tipo = tipo;
    }
}
