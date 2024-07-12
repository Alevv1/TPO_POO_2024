package vista;

import DTO.UsuarioDTO;
import controller.ControllerUsuarios;
import model.enums.TipoRol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class FrmModificarUsuario extends JDialog {
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel Usuario;
    private JLabel Rol;

    public FrmModificarUsuario(UsuarioDTO usuarioDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        Usuario.setText(String.valueOf(usuarioDTO.NroUsuario));
        textField2.setText(usuarioDTO.email);
        passwordField1.setText(usuarioDTO.password);
        textField4.setText(usuarioDTO.nombre);
        textField5.setText(usuarioDTO.domicilio);
        textField6.setText(String.valueOf(usuarioDTO.DNI));
        textField7.setText(usuarioDTO.nacimiento);
        Rol.setText(String.valueOf(usuarioDTO.rol));
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioDTO usuarioDTO = new UsuarioDTO(parseInt(Usuario.getText()), textField2.getText(), passwordField1.toString(), textField4.getText(), textField5.getText(), parseInt(textField6.getText()), textField7.getText(), TipoRol.valueOf(Rol.getText()));
                ControllerUsuarios.getInstancia().modificacionUsuario(usuarioDTO);
                setVisible(false);
            }
        });
    }

}
