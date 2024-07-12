package DAO;

import model.Practicas;
import model.UsuarioSistema;
import util.GenericDAO;

public class UsuarioSistemaDAO extends GenericDAO<UsuarioSistema> {
    public UsuarioSistemaDAO() throws Exception {
        super(UsuarioSistema.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\UsuarioSistema.txt");
    }
}
