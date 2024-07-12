package DAO;

import DTO.ResultadoPeticionDTO;
import util.GenericDAO;

public class ResultadoDTODAO extends GenericDAO<ResultadoPeticionDTO> {
    public ResultadoDTODAO() throws Exception {
        super(ResultadoPeticionDTO.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\ResultadoDTO.txt");
    }
}
