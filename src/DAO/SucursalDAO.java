package DAO;

import model.Sucursal;
import util.GenericDAO;

public class SucursalDAO extends GenericDAO<Sucursal> {
    public SucursalDAO() throws Exception {
        super(Sucursal.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\Sucursal.txt");
    }
}
