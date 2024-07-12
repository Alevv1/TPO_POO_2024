package DAO;

import DTO.PeticionesDTO;
import util.GenericDAO;

public class PeticionesDTODAO extends GenericDAO<PeticionesDTO> {
    public PeticionesDTODAO() throws Exception {
        super(PeticionesDTO.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\PeticionesDTO.txt");
    }
}
