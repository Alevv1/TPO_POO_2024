package vista;

import DTO.PeticionesDTO;
import DTO.SucursalDTO;
import controller.ControllerSucursal;
import model.Peticiones;
import model.Sucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmSucursales extends JInternalFrame {

    private JPanel pnlPrincipal;
    private JButton nuevaSucursalButton;
    private JButton modificarSucursalButton;
    private JButton eliminarSucursalButton;
    private JButton listarPacientesButton;
    private JButton listarPeticionesButton;
    private JButton listarPracticasButton;
    private JComboBox comboBox1;
    private JButton agregarPracticaButton;


    public FrmSucursales(){
        super("Sucursales");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevaSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaSucursal dialog = new FrmNuevaSucursal();
                dialog.setVisible(true);
                asignarDatosCombo();

            }
        });
        modificarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarSucursal dialog = new FrmModificarSucursal((SucursalDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });

        eliminarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (ControllerSucursal.getInstancia().NotienePeticionesFinalizadas((SucursalDTO) comboBox1.getSelectedItem()) == true) {
                        FrmEliminarSucursal dialog = new FrmEliminarSucursal((SucursalDTO) comboBox1.getSelectedItem());
                        dialog.setVisible(true);
                    } else {
                        FrmNoSeEliminoSucursal dialog1 = new FrmNoSeEliminoSucursal();
                        dialog1.setVisible(true);
                    }
                    asignarDatosCombo();
                }
        });
        listarPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmListaPacientesSucursal dialog = new FrmListaPacientesSucursal((SucursalDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
            }
        });
        listarPracticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmListaPracticasSucursal dialog = new FrmListaPracticasSucursal((SucursalDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
            }
        });
        listarPeticionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmListaPeticionesSucursal dialog = new FrmListaPeticionesSucursal((SucursalDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);

            }
        });
        agregarPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem() != null) {
                    FrmAgregarPracticaSucursal dialog = new FrmAgregarPracticaSucursal((SucursalDTO) comboBox1.getSelectedItem());
                    dialog.setVisible(true);
                    asignarDatosCombo();
                }
            }
        });
    }
    private void asignarDatosCombo() {
        ArrayList<SucursalDTO> listaSucursales = new ArrayList<SucursalDTO>();
        for (SucursalDTO sucursalDTO: ControllerSucursal.getInstancia().getListaSucursalDTO())
            listaSucursales.add(sucursalDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaSucursales);
        comboBox1.setModel(modelo);
    }
}
