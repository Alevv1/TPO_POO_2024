package vista;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import DTO.PracticasDTO;
import DTO.SucursalDTO;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import model.enums.TipoEstado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmNuevaPeticion extends JDialog {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox2;
    private JTextField textField5;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JLabel SucursalNumero;

    public FrmNuevaPeticion(SucursalDTO sucursalDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosComboPaciente();
        asignarDatosComboPracticas(sucursalDTO);
        SucursalNumero.setText(String.valueOf(sucursalDTO.numero));
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteDTO pacienteDTO = (PacienteDTO) comboBox1.getSelectedItem();
                int pacienteID = pacienteDTO.DNI;
                int sucursalID = sucursalDTO.numero;
                PeticionesDTO peticionesDTO = new PeticionesDTO(pacienteID, sucursalID,(PracticasDTO) comboBox4.getSelectedItem(), textField1.getText(), textField2.getText(), textField4.getText(), TipoEstado.En_proceso, parseInt(textField5.getText()));
                ControllerPeticiones.getInstancia().altaPeticion(peticionesDTO);
                setVisible(false);
            }
        });
    }

    private void asignarDatosComboPaciente() {
        ArrayList<PacienteDTO> listaPacientes = new ArrayList<PacienteDTO>();
        for (PacienteDTO pacienteDTO: ControllerSucursal.getInstancia().getListaPacienteDTO())
            listaPacientes.add(pacienteDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaPacientes);
        comboBox1.setModel(modelo);
    }

    private void asignarDatosComboPracticas(SucursalDTO sucursalDTO) {
        ArrayList<PracticasDTO> listaPracticas = ControllerSucursal.getInstancia().listarPracticasSucursal(sucursalDTO);

        DefaultComboBoxModel modeloPracticas = new DefaultComboBoxModel();
        modeloPracticas.addAll(listaPracticas);
        comboBox4.setModel(modeloPracticas);


    }
}
