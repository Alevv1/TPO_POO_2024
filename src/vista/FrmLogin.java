package vista;

import DTO.UsuarioDTO;
import controller.ControllerUsuarios;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmLogin extends JFrame{
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton ingresarButton;
    private JButton cerrarButton;

    public FrmLogin() {
        super("Login");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal((UsuarioDTO) comboBox1.getSelectedItem());
                menuPrincipal.setVisible(true);
                setVisible(false);
            }
        });
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerSucursal.getInstancia().cerrarController();
                ControllerUsuarios.getInstancia().cerrarController();
                ControllerPeticiones.getInstancia().cerrarController();
                System.exit(0);
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
