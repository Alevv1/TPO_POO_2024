package model;

import model.enums.TipoRango;
import model.enums.TipoValor;

public class Regla {
    private int codigo;
    private TipoValor tipoValor;
    private TipoRango tipoRango;

    public TipoValor getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(TipoValor tipoValor) {
        this.tipoValor = tipoValor;
    }

    private double valorCritico;
    private boolean valorReservado;

    public boolean isValorReservado() {
        return valorReservado;
    }

    public void setValorReservado(boolean valorReservado) {
        this.valorReservado = valorReservado;
    }

    public Regla(int codigo, TipoValor tipoValor, boolean valorReservado) {
        this.codigo = codigo;
        this.tipoValor = tipoValor;
        this.valorReservado = valorReservado;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    public TipoRango getTipoRango() {
        return tipoRango;
    }

    public void setTipoRango(TipoRango tipoRango) {
        this.tipoRango = tipoRango;
    }

    public double getValorCritico() {
        return valorCritico;
    }

    public void setValorCritico(double valorCritico) {
        this.valorCritico = valorCritico;
    }

}
