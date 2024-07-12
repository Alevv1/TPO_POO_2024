package DAO;

import model.Paciente;
import util.GenericDAO;


public class PacienteDAO extends GenericDAO<Paciente> {
    public PacienteDAO() throws Exception {
        super(Paciente.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\Paciente.txt");
    }
}
