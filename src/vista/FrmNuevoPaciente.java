package vista;

import DTO.PacienteDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class FrmNuevoPaciente extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JRadioButton masculinoRadioButton;
    private JTextField textField8;
    private JTextField textField6;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JTextField textField5;

    public FrmNuevoPaciente() {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteDTO pacienteDTO = new PacienteDTO(parseInt(textField1.getText()), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(), parseInt(textField6.getText()));
                ControllerSucursal.getInstancia().altaPaciente(pacienteDTO);
                setVisible(false);

            }
        });
    }
}
