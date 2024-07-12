package vista;

import DTO.PacienteDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class FrmModificarPaciente extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel DNI;

    public FrmModificarPaciente(PacienteDTO pacienteDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        DNI.setText(String.valueOf(pacienteDTO.DNI));
        setContentPane(pnlPrincipal);
        textField2.setText(pacienteDTO.nombre);
        textField3.setText(pacienteDTO.domicilio);
        textField4.setText(pacienteDTO.mail);
        textField5.setText(pacienteDTO.sexo);
        textField6.setText(String.valueOf(pacienteDTO.edad));
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteDTO pacienteDTO = new PacienteDTO(parseInt(DNI.getText()), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(), parseInt(textField6.getText()));
                ControllerSucursal.getInstancia().modificacionPaciente(pacienteDTO);
                setVisible(false);
            }
        });
    }
}
