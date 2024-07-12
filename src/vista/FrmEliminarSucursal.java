package vista;

import DTO.PacienteDTO;
import DTO.SucursalDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmEliminarSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton guardarButton;

    public FrmEliminarSucursal(SucursalDTO sucuBaja) {
        setSize(600, 300);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo(sucuBaja);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO sucuDerivacion = (SucursalDTO) comboBox1.getSelectedItem();
                ControllerSucursal.getInstancia().bajaSucursal(sucuBaja, sucuDerivacion);
                setVisible(false);
            }
        });
    }

    private void asignarDatosCombo(SucursalDTO sucuBaja) {
        SucursalDTO sucursalBaja = null;
        ArrayList<SucursalDTO> listaSucursales = new ArrayList<SucursalDTO>();
        for (SucursalDTO sucursalDTO: ControllerSucursal.getInstancia().getListaSucursalDTO())
            listaSucursales.add(sucursalDTO);
        for (SucursalDTO sucursalDTO: listaSucursales)
            if (sucursalDTO.numero == sucuBaja.numero)
                sucursalBaja = sucursalDTO;
        listaSucursales.remove(sucursalBaja);
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaSucursales);
        comboBox1.setModel(modelo);
    }
}
