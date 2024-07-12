package vista;

import DTO.PacienteDTO;
import DTO.UsuarioDTO;
import controller.ControllerSucursal;
import model.enums.TipoRol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmPacientes extends JInternalFrame {
    private JButton nuevoPacienteButton;
    private JButton modificarPacienteButton;
    private JButton eliminarPacienteButton;
    private JPanel pnlPrincipal;
    private JButton listarPeticionesPorPacienteButton;
    private JComboBox comboBox1;

    public FrmPacientes(UsuarioDTO usuarioDTO) {
        super("Pacientes");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        if (usuarioDTO.rol == TipoRol.RECEPCIONISTA) {
            modificarPacienteButton.setVisible(false);
            eliminarPacienteButton.setVisible(false);
        }
        nuevoPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoPaciente dialog = new FrmNuevoPaciente();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        modificarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPaciente dialog = new FrmModificarPaciente((PacienteDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        eliminarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteDTO pacienteDTO = (PacienteDTO) comboBox1.getSelectedItem();
                ControllerSucursal.getInstancia().bajaPaciente(pacienteDTO);
                if (ControllerSucursal.getInstancia().getListaPacienteDTO().indexOf(pacienteDTO) != -1) {
                    FrmNoSeEliminoPaciente dialog = new FrmNoSeEliminoPaciente();
                    dialog.setVisible(true);
                }
                asignarDatosCombo();
            }
        });
        listarPeticionesPorPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmListarPeticionesPaciente dialog = new FrmListarPeticionesPaciente((PacienteDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<PacienteDTO> listaPacientes = new ArrayList<PacienteDTO>();
        for (PacienteDTO pacienteDTO: ControllerSucursal.getInstancia().getListaPacienteDTO())
            listaPacientes.add(pacienteDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaPacientes);
        comboBox1.setModel(modelo);
    }
}
