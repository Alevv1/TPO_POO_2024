package model;

import DTO.PacienteDTO;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private int numero ;
    private String direccion;
    private UsuarioSistema responsableTecnico;
    private  ArrayList<Peticiones> listaPeticiones;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Practicas> listaPracticas;

    //CONSTRUCTOR
    public Sucursal(int numero, String direccion,UsuarioSistema responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
        listaPeticiones= new ArrayList<Peticiones>();
        listaPacientes= new ArrayList<Paciente>();
        listaPracticas = new ArrayList<Practicas>();
    }
    //GETTER Y SETTER


    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public ArrayList<Peticiones> getListaPeticiones() {
        return listaPeticiones;
    }

    public ArrayList<Practicas> getListaPracticas() {
        return listaPracticas;
    }

    public void setListaPracticas(ArrayList<Practicas> listaPracticas) {
        this.listaPracticas = listaPracticas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public UsuarioSistema getResponsableTecnico() {
        return responsableTecnico;
    }

    public void setResponsableTecnico(UsuarioSistema responsableTecnico) {
        this.responsableTecnico = responsableTecnico;
    }



    //METODOS:
    public int agregarPeticion(Peticiones p)
    {
        listaPeticiones.add(p);
        return listaPeticiones.size();
    }

    public int agregarPaciente(Paciente p)
    {
        listaPacientes.add(p);
        return listaPacientes.size();
    }

    public int agregarPractica(Practicas p) {
        listaPracticas.add(p);
        return listaPracticas.size();
    }
}
