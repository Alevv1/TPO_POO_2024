package DAO;

import DTO.SucursalDTO;
import model.Sucursal;
import util.GenericDAO;

public class SucursalDTODAO extends GenericDAO<SucursalDTO> {
    public SucursalDTODAO() throws Exception {
        super(SucursalDTO.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\SucursalDTO.txt");
    }
}
