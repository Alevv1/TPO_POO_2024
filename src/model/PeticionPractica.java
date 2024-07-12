package model;

import model.enums.TipoEstado;

public class PeticionPractica {
    private TipoEstado estadoPractica;

    public PeticionPractica(TipoEstado estadoPractica) {
        this.estadoPractica = estadoPractica;
    }

    public TipoEstado getEstadoPractica() {
        return estadoPractica;
    }

    public void setEstadoPractica(TipoEstado estadoPractica) {
        this.estadoPractica = estadoPractica;
    }
}
