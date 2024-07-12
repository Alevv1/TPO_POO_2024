package DAO;

import model.Practicas;
import model.Sucursal;
import util.GenericDAO;

public class PracticasDAO extends GenericDAO<Practicas> {
    public PracticasDAO() throws Exception {
        super(Practicas.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\Practicas.txt");
    }
}
