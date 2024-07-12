package DAO;

import model.Resultado;
import model.UsuarioSistema;
import util.GenericDAO;

public class ResultadoDAO extends GenericDAO<Resultado> {
    public ResultadoDAO() throws Exception {
        super(Resultado.class, "C:\\Users\\Alejandro\\OneDrive - Fundación UADE\\Escritorio\\TPO_POO_2024\\src\\txt\\Resultado.txt");
    }
}
