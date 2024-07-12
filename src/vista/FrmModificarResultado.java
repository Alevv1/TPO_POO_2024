package vista;

import DTO.ResultadoPeticionDTO;
import controller.ControllerPeticiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmModificarResultado extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel ID;
    private JLabel Peticion;
    private JComboBox comboBox1;

    public FrmModificarResultado(ResultadoPeticionDTO resultadoPeticionDTO) {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosComboBoolean();

        ID.setText(String.valueOf(resultadoPeticionDTO.ID));
        textField2.setText(String.valueOf(resultadoPeticionDTO.valorNumerico));
        comboBox1.setSelectedItem(resultadoPeticionDTO.valorBooleano);
        Peticion.setText(String.valueOf(resultadoPeticionDTO.peticion.nroPeticion));
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoPeticionDTO resultado1 = new ResultadoPeticionDTO(parseInt(ID.getText()), resultadoPeticionDTO.peticion);
                if (!textField2.getText().isEmpty())
                    resultado1.valorNumerico = parseInt(textField2.getText());
                if (comboBox1.getSelectedItem() != null)
                    resultado1.valorBooleano = (boolean) comboBox1.getSelectedItem();
                ControllerPeticiones.getInstancia().modificacionResultado(resultado1);
                setVisible(false);
            }
        });
    }

    private void asignarDatosComboBoolean() {
        ArrayList<Boolean> listaBoolean = new ArrayList<>();
        listaBoolean.add(true);
        listaBoolean.add(false);

        DefaultComboBoxModel modeloB = new DefaultComboBoxModel();
        modeloB.addAll(listaBoolean);
        comboBox1.setModel(modeloB);
    }
}
