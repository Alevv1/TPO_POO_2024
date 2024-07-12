package vista;

import DTO.PracticasDTO;
import DTO.ReglaDTO;
import controller.ControllerUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmNuevaPractica extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox3;

    public FrmNuevaPractica() {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosComboPracticas();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PracticasDTO practicasDTO = new PracticasDTO(parseInt(textField1.getText()), textField2.getText(), textField3.getText(), parseInt(textField4.getText()), (ReglaDTO) comboBox3.getSelectedItem());
                ControllerUsuarios.getInstancia().altaPractica(practicasDTO);
                setVisible(false);
            }
        });
    }
    private void asignarDatosComboPracticas() {
        ArrayList<ReglaDTO> listaReglas = new ArrayList<ReglaDTO>();
        for (ReglaDTO regla: ControllerUsuarios.getInstancia().listaReglaDTO) {
            listaReglas.add(regla);
        }

        DefaultComboBoxModel modeloReglas = new DefaultComboBoxModel();
        modeloReglas.addAll(listaReglas);
        comboBox3.setModel(modeloReglas);
    }
}
