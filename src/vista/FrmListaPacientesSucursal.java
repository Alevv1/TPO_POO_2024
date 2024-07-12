package vista;

import DTO.PacienteDTO;
import DTO.SucursalDTO;
import controller.ControllerSucursal;
import model.Paciente;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListaPacientesSucursal extends JDialog{
    private JList list1;
    private JPanel pnlPrincipal;
    public FrmListaPacientesSucursal(SucursalDTO sucursalDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosLista(sucursalDTO);
    }

    public void asignarDatosLista(SucursalDTO sucursalDTO) {
        ArrayList<PacienteDTO> listaPacientes = ControllerSucursal.getInstancia().listarPacientesSucursales(sucursalDTO);
        DefaultListModel model = new DefaultListModel();
        model.addAll(listaPacientes);
        list1.setModel(model);
    }
}
