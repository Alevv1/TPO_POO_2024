package vista;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import DTO.SucursalDTO;
import controller.ControllerSucursal;
import model.Paciente;
import model.Peticiones;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListarPeticionesPaciente extends JDialog {
    private JPanel pnlPrincipal;
    private JList list1;

    public FrmListarPeticionesPaciente(PacienteDTO pacienteDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosLista(pacienteDTO);
    }

    public void asignarDatosLista(PacienteDTO pacienteDTO) {
        ArrayList<PeticionesDTO> listaPeticiones = ControllerSucursal.getInstancia().listarPeticionesPaciente(pacienteDTO);
        DefaultListModel model = new DefaultListModel();
        model.addAll(listaPeticiones);
        list1.setModel(model);
    }
}
