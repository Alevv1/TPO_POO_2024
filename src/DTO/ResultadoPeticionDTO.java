package DTO;

import model.enums.TipoEstado;

public class ResultadoPeticionDTO {
    public int ID;
    public TipoEstado estadoPractica;

    public int valorNumerico;
    public boolean valorBooleano;
    public PeticionesDTO peticion;
    public boolean esValorCritico;
    public boolean esValorReservado;
    @Override
    public String toString() {
        return "ID: " + ID;
    }

    public ResultadoPeticionDTO(TipoEstado estadoPractica) {
        this.estadoPractica = estadoPractica;
    }

    public TipoEstado getEstadoPractica() {
        return estadoPractica;
    }

    public void setEstadoPractica(TipoEstado estadoPractica) {
        this.estadoPractica = estadoPractica;
    }
    public ResultadoPeticionDTO(int ID, PeticionesDTO peticion) {
        this.ID = ID;
        this.peticion = peticion;
    }
}
