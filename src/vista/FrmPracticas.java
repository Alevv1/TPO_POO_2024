package vista;

import DTO.PracticasDTO;
import controller.ControllerUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmPracticas extends JInternalFrame {
    private JButton nuevaPracticaButton;
    private JButton modificarPracticaButton;
    private JButton eliminarPracticaButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;

    public FrmPracticas() {
        super("Practicas");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevaPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaPractica dialog = new FrmNuevaPractica();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        modificarPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPractica dialog = new FrmModificarPractica((PracticasDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        eliminarPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PracticasDTO practicasDTO = (PracticasDTO) comboBox1.getSelectedItem();
                ControllerUsuarios.getInstancia().bajaPractica(practicasDTO);
                asignarDatosCombo();
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
