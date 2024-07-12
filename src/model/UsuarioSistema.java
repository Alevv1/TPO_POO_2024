package model;

import model.enums.TipoRol;

import java.time.LocalDate;

public class UsuarioSistema {
    private int NroUsuario;
    private String email ;
    private String password;
    private String nombre;
    private String domicilio;
    private int DNI;
    private String nacimiento;
    private TipoRol rol;


    //CONSTRUCTOR
    public UsuarioSistema(int NroUsuario, String email, String password, String nombre, String domicilio, int DNI, String nacimiento, TipoRol rol) {
        this.NroUsuario = NroUsuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.nacimiento = nacimiento;
        this.rol = rol;
    }

    //GETTER AND SETTERS
    public int getNroUsuario() {
        return NroUsuario;
    }

    public void setNroUsuario(int NroUsuario) {
        this.NroUsuario = NroUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public TipoRol getRol() {
        return rol;
    }

    public void setRol(TipoRol rol) {
        this.rol = rol;
    }

    //METODOS

}
