package DAO;

import DTO.UsuarioDTO;
import util.GenericDAO;

public class UsuarioSistemaDTODAO extends GenericDAO<UsuarioDTO> {
    public UsuarioSistemaDTODAO() throws Exception {
        super(UsuarioDTO.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\UsuarioSistemaDTO.txt");
    }
}
