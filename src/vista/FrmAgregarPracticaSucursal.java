package vista;

import DTO.PracticasDTO;
import DTO.SucursalDTO;
import controller.ControllerUsuarios;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmAgregarPracticaSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton guardarButton;

    public FrmAgregarPracticaSucursal(SucursalDTO sucursalDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerSucursal.getInstancia().AgregarPracticaSucursal(sucursalDTO, (PracticasDTO) comboBox1.getSelectedItem());
                setVisible(false);

            }
        });
    }
    private void asignarDatosCombo() {
        ArrayList<PracticasDTO> listaPracticas = new ArrayList<>();
        for (PracticasDTO practicasDTO: ControllerUsuarios.getInstancia().getListaPracticasDTO())
            listaPracticas.add(practicasDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaPracticas);
        comboBox1.setModel(modelo);
    }
}
