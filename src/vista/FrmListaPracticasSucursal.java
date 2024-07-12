package vista;

import DTO.PracticasDTO;
import DTO.SucursalDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListaPracticasSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JList list1;

    public FrmListaPracticasSucursal(SucursalDTO sucursalDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosLista(sucursalDTO);

    }

    public void asignarDatosLista(SucursalDTO sucursalDTO) {
        ArrayList<PracticasDTO> listaPracticas = ControllerSucursal.getInstancia().listarPracticasSucursal(sucursalDTO);
        DefaultListModel model = new DefaultListModel();
        model.addAll(listaPracticas);
        list1.setModel(model);
    }
}
