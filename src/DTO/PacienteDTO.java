package DTO;

import model.Peticiones;

import java.util.ArrayList;

public class PacienteDTO {
    public int DNI;
    public String nombre;
    public String domicilio;
    public String mail;
    public String sexo;
    public int edad;



    //CONSTRUCTOR
    public PacienteDTO(int DNI, String nombre, String domicilio, String mail, String sexo, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return
                "DNI: " + DNI + " Nombre: " + nombre;
    }
}
