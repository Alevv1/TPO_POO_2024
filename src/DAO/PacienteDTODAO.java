package DAO;

import DTO.PacienteDTO;
import model.Sucursal;
import util.GenericDAO;

public class PacienteDTODAO extends GenericDAO<PacienteDTO> {
    public PacienteDTODAO() throws Exception {
        super(PacienteDTO.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\PacienteDTO.txt");
    }
}
