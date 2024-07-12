package DAO;

import DTO.PracticasDTO;
import util.GenericDAO;

public class PracticasDTODAO extends GenericDAO<PracticasDTO> {
    public PracticasDTODAO() throws Exception {
        super(PracticasDTO.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\PracticasDTO.txt");
    }
}
