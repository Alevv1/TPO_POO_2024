package DTO;

public class SucursalDTO {
    public int numero ;
    public String direccion;
    public UsuarioDTO responsableTecnico;


    @Override
    public String toString() {
        return "Número: " + numero + " Dirección: " + direccion;
    }

    public SucursalDTO(int numero, String direccion, UsuarioDTO responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
    }
}
