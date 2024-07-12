package DTO;

import model.enums.TipoRol;

public class UsuarioDTO {
    public int NroUsuario;
    public String email ;
    public String password;
    public String nombre;
    public String domicilio;
    public int DNI;
    public String nacimiento;
    public TipoRol rol;

    @Override
    public String toString() {
        return "Usuario: " + NroUsuario + " Nombre: " + nombre + " Rol: " + rol;
    }

    public UsuarioDTO(int NroUsuario, String email, String password, String nombre, String domicilio, int DNI, String nacimiento, TipoRol rol) {
        this.NroUsuario = NroUsuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.nacimiento = nacimiento;
        this.rol = rol;
    }
}
