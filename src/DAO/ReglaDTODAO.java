package DAO;

import DTO.ReglaDTO;
import model.Paciente;
import util.GenericDAO;

public class ReglaDTODAO extends GenericDAO<ReglaDTO> {
    public ReglaDTODAO() throws Exception {
        super(ReglaDTO.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\ReglaDTO.txt");
    }
}
