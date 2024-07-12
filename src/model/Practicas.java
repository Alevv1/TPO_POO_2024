package model;

import model.enums.TipoValor;

public class Practicas {
    private int codigo;
    private String nombrePractica;
    private String grupo;
    private int horasResultado;
    private boolean estado;
    private Regla regla;

    //CONSTRUCTOR
    public Practicas(int codigo, String nombrePractica, String grupo,  int horasResultado) {
        this.codigo = codigo;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.horasResultado = horasResultado;
        estado=true;
    }

    //GETTER AND SETTER
    public int getCodigo() {
        return codigo;
    }
    public boolean getEstado(){
        return estado;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrePractica() {
        return nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Regla getRegla() {
        return regla;
    }

    public void setRegla(Regla regla) {
        this.regla = regla;
    }

    public int getHorasResultado() {
        return horasResultado;
    }

    public void setHorasResultado(int horasResultado) {
        this.horasResultado = horasResultado;
    }



}
