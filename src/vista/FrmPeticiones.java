package vista;

import DTO.PeticionesDTO;
import DTO.UsuarioDTO;
import controller.ControllerPeticiones;
import model.enums.TipoRol;
import model.enums.TipoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmPeticiones extends JInternalFrame {
    private JButton nuevaPeticionButton;
    private JButton modificarPeticionButton;
    private JButton eliminarPeticionButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton verResultadosButton;
    private JButton listarPeticionesEnValoresButton;

    public FrmPeticiones(UsuarioDTO usuarioDTO) {
        super("Peticiones");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        if (usuarioDTO.rol == TipoRol.RECEPCIONISTA) {
            modificarPeticionButton.setVisible(false);
            eliminarPeticionButton.setVisible(false);
            listarPeticionesEnValoresButton.setVisible(false);
        }
        nuevaPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmElegirSucursalPeticion dialog = new FrmElegirSucursalPeticion();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        modificarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPeticion dialog = new FrmModificarPeticion((PeticionesDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        eliminarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionesDTO = (PeticionesDTO) comboBox1.getSelectedItem();
                ControllerPeticiones.getInstancia().bajaPeticion(peticionesDTO);
                asignarDatosCombo();
            }
        });
        verResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionDTO = (PeticionesDTO) comboBox1.getSelectedItem();
                if (peticionDTO.resultadoDTO != 0 && !ControllerPeticiones.getInstancia().tieneResultadoValorReservado(peticionDTO)) {
                    if (peticionDTO.practicaAsociada.regla.tipoValor == TipoValor.NUMERICO) {
                        FrmMostrarResultadosNumerico dialog = new FrmMostrarResultadosNumerico(peticionDTO);
                        dialog.setVisible(true);
                    } else {
                        FrmMostrarResultadoBooleano dialog = new FrmMostrarResultadoBooleano(peticionDTO);
                        dialog.setVisible(true);
                    }
                } else if (peticionDTO.resultadoDTO != 0 && ControllerPeticiones.getInstancia().tieneResultadoValorReservado(peticionDTO)){
                    FrmRetirarPorSucursal dialog = new FrmRetirarPorSucursal();
                    dialog.setVisible(true);
                }
            }
        });
        listarPeticionesEnValoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmListaPeticionesValoresCriticos dialog = new FrmListaPeticionesValoresCriticos();
                dialog.setVisible(true);
            }
        });
    }
        private void asignarDatosCombo () {
            ArrayList<PeticionesDTO> listaPeticiones = new ArrayList<PeticionesDTO>();
            for (PeticionesDTO peticionesDTO : ControllerPeticiones.getInstancia().getListaPeticionesDTO())
                listaPeticiones.add(peticionesDTO);


            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            modelo.addAll(listaPeticiones);
            comboBox1.setModel(modelo);
        }
    }
