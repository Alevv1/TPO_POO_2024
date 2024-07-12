package DAO;

import model.Peticiones;
import util.GenericDAO;

public class PeticionesDAO extends GenericDAO<Peticiones> {
    public PeticionesDAO() throws Exception {
        super(Peticiones.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\Peticiones.txt");
    }
}
