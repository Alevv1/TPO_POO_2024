package vista;

import DTO.SucursalDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmElegirSucursalPeticion extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton guardarButton;

    public FrmElegirSucursalPeticion() {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaPeticion dialog = new FrmNuevaPeticion((SucursalDTO) comboBox1.getSelectedItem());
                setVisible(false);
                dialog.setVisible(true);

            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<SucursalDTO> listaSucursales = new ArrayList<SucursalDTO>();
        for (SucursalDTO sucursalDTO : ControllerSucursal.getInstancia().getListaSucursalDTO())
            listaSucursales.add(sucursalDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaSucursales);
        comboBox1.setModel(modelo);
    }
}
