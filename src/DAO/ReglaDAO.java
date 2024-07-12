package DAO;

import model.Paciente;
import model.Regla;
import util.GenericDAO;

public class ReglaDAO extends GenericDAO<Regla> {
    public ReglaDAO() throws Exception {
        super(Regla.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\Regla.txt");
    }
}
