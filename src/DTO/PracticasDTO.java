package DTO;

import model.Regla;
import model.enums.TipoValor;

public class PracticasDTO {
    public int codigo;
    public String nombrePractica;
    public String grupo;
    public int horasResultado;
    public ReglaDTO regla;

    @Override
    public String toString() {
        return "Código: " + codigo + " Nombre Práctica: " + nombrePractica + " Regla: " + regla;
    }

    public PracticasDTO(int codigo, String nombrePractica, String grupo, int horasResultado, ReglaDTO regla) {
        this.codigo = codigo;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.horasResultado = horasResultado;
        this.regla = regla;
    }
}
