package vista;

import DTO.UsuarioDTO;
import controller.ControllerUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmUsuario extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JButton nuevoUsuarioButton;
    private JButton modificarUsuarioButton;
    private JButton eliminarUsuarioButton;
    private JComboBox comboBox1;

    public FrmUsuario() {
        super("Usuarios");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoUsuario dialog = new FrmNuevoUsuario();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        modificarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarUsuario dialog = new FrmModificarUsuario((UsuarioDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioDTO usuarioDTO = (UsuarioDTO) comboBox1.getSelectedItem();
                ControllerUsuarios.getInstancia().bajaUsuario(usuarioDTO);
                asignarDatosCombo();
            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
        for (UsuarioDTO usuarioDTO : ControllerUsuarios.getInstancia().getListaUsuariosDTO())
            listaUsuarios.add(usuarioDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaUsuarios);
        comboBox1.setModel(modelo);
    }
}
