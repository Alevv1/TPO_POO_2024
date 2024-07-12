package DTO;

import model.Paciente;
import model.Practicas;
import model.Sucursal;
import model.enums.TipoEstado;

import java.time.LocalDate;
import java.util.List;

public class PeticionesDTO {

    public int paciente;
    public int sucursal;
    public String ObraSocial;
    public String fechaCarga;
    public PracticasDTO practicaAsociada;
    public String fechaEntrega;
    public TipoEstado estado;
    public int nroPeticion;
    public int resultadoDTO;

    @Override
    public String toString() {
        return "Paciente: " + paciente + " Sucursal: " + sucursal + " Petición: " + nroPeticion
                + " Estado: " + estado;

    }

    public PeticionesDTO(int paciente, int sucursal, PracticasDTO practicaAsociada,String obraSocial, String fechaCarga, String fechaEntrega, TipoEstado estado, int nroPeticion) {
        this.paciente = paciente;
        this.ObraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.practicaAsociada = practicaAsociada;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nroPeticion = nroPeticion;
        this.sucursal=sucursal;
    }
}
