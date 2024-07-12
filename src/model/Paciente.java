package model;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int DNI;
    private String nombre;
    private String domicilio;
    private String mail;
    private String sexo;
    private int edad;
    private ArrayList<Peticiones> listaPeticionesPaciente;



    //CONSTRUCTOR
    public Paciente(int DNI, String nombre, String domicilio, String mail, String sexo, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
        listaPeticionesPaciente= new ArrayList<Peticiones>();

    }

    //GETTER Y SETTER
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Peticiones> getListaPeticionesPaciente() {
        return listaPeticionesPaciente;
    }



    public void AgregarPeticion(Peticiones p){
        listaPeticionesPaciente.add(p);
    }
}
