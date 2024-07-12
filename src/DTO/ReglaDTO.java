package DTO;

import model.enums.TipoRango;
import model.enums.TipoValor;

public class ReglaDTO {
    public int codigo;
    public TipoRango tipoRango;
    public TipoValor tipoValor;

    @Override
    public String toString() {
        return "Código: " + codigo;
    }

    public double valorCritico;
    public boolean valorReservado;

    public ReglaDTO(int codigo, TipoValor tipoValor, boolean valorReservado) {
        this.codigo = codigo;
        this.tipoValor = tipoValor;
        this.valorReservado = valorReservado;
    }

}
