package vista;

import DTO.ReglaDTO;
import controller.ControllerUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmReglas extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton nuevaReglaButton;
    private JButton eliminarReglaButton;

    public FrmReglas() {
        super("Reglas");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevaReglaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaRegla dialog = new FrmNuevaRegla();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });

        eliminarReglaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReglaDTO reglaDTO = (ReglaDTO) comboBox1.getSelectedItem();
                ControllerUsuarios.getInstancia().bajaRegla(reglaDTO);
                asignarDatosCombo();
            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<ReglaDTO> listaReglas = new ArrayList<ReglaDTO>();
        for (ReglaDTO reglaDTO: ControllerUsuarios.getInstancia().getListaReglaDTO())
            listaReglas.add(reglaDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaReglas);
        comboBox1.setModel(modelo);
    }
}
