package vista;

import DTO.ReglaDTO;
import controller.ControllerUsuarios;
import model.enums.TipoRango;
import model.enums.TipoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmNuevaRegla extends JDialog {
    private JPanel pnlPrincipal;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton guardarButton;
    private JTextField textField2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textField3;

    public FrmNuevaRegla() {
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosComboRango();
        asignarDatosComboValores();
        asignarDatosComboReservado();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReglaDTO reglaDTO = new ReglaDTO(parseInt(textField1.getText()), (TipoValor) comboBox3.getSelectedItem(), (Boolean) comboBox4.getSelectedItem());
                if (comboBox1.getSelectedItem() != null)
                    reglaDTO.tipoRango = (TipoRango) comboBox1.getSelectedItem();
                if (!textField2.getText().isEmpty())
                    reglaDTO.valorCritico = Double.parseDouble(textField2.getText());
                ControllerUsuarios.getInstancia().altaRegla(reglaDTO);
                setVisible(false);
            }
        });
    }

    private void asignarDatosComboRango() {
        ArrayList<TipoRango> listaRango = new ArrayList<TipoRango>();
        for (TipoRango tipoRango : TipoRango.values()) {
            listaRango.add(tipoRango);
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaRango);
        comboBox1.setModel(modelo);
    }
    private void asignarDatosComboValores() {
        ArrayList<TipoValor> listaValores = new ArrayList<TipoValor>();
        for (TipoValor tipoValor: TipoValor.values()) {
            listaValores.add(tipoValor);
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaValores);
        comboBox3.setModel(modelo);
    }
    private void asignarDatosComboReservado() {
        ArrayList<Boolean> listaBoolean = new ArrayList<Boolean>();
        listaBoolean.add(true);
        listaBoolean.add(false);
        DefaultComboBoxModel modeloR = new DefaultComboBoxModel();
        modeloR.addAll(listaBoolean);
        comboBox4.setModel(modeloR);
    }
}
