package vista;

import DTO.PeticionesDTO;
import DTO.SucursalDTO;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListaPeticionesValoresCriticos extends JDialog {
    private JPanel pnlPrincipal;
    private JList list1;

    public FrmListaPeticionesValoresCriticos() {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosLista();
    }

    public void asignarDatosLista() {
        ArrayList<PeticionesDTO> listaPeticiones = new ArrayList<PeticionesDTO>();
        for (PeticionesDTO peticionDTO: ControllerPeticiones.getInstancia().getListaPeticionesDTO())
            if (peticionDTO.resultadoDTO != 0)
                if (ControllerPeticiones.getInstancia().tieneResultadoValorCritico(peticionDTO))
                    listaPeticiones.add(peticionDTO);

        DefaultListModel model = new DefaultListModel();
        model.addAll(listaPeticiones);
        list1.setModel(model);
    }
}
