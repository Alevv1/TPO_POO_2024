package vista;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import DTO.PracticasDTO;
import DTO.SucursalDTO;
import controller.ControllerPeticiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class FrmModificarPeticion extends JDialog {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel Numero;
    private JLabel Paciente;
    private JLabel Sucursal;
    private JLabel PracticaAsociada;

    public FrmModificarPeticion(PeticionesDTO peticionesDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        int pacienteDTO = peticionesDTO.paciente;
        int sucursalDTO = peticionesDTO.sucursal;
        PracticasDTO practicasDTO = peticionesDTO.practicaAsociada;
        Paciente.setText(String.valueOf(peticionesDTO.paciente));
        Sucursal.setText(String.valueOf(peticionesDTO.sucursal));
        PracticaAsociada.setText(String.valueOf(peticionesDTO.practicaAsociada));
        textField1.setText(peticionesDTO.ObraSocial);
        textField2.setText(peticionesDTO.fechaCarga);
        textField4.setText(peticionesDTO.fechaEntrega);
        Numero.setText(String.valueOf(peticionesDTO.nroPeticion));
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionDTO = new PeticionesDTO(pacienteDTO, sucursalDTO, practicasDTO, textField1.getText(), textField2.getText(), textField4.getText(), peticionesDTO.estado, parseInt(Numero.getText()));
                ControllerPeticiones.getInstancia().modificacionPeticion(peticionDTO);
                setVisible(false);
            }
        });
    }

}
