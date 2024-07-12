package vista;

import DTO.ResultadoPeticionDTO;
import DTO.UsuarioDTO;
import controller.ControllerPeticiones;
import model.enums.TipoRol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmResultado extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton nuevoResultadoButton;
    private JButton modificarResultadoButton;
    private JButton eliminarResultadoButton;

    public FrmResultado(UsuarioDTO usuarioDTO) {
        super("Resultado");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        if (usuarioDTO.rol == TipoRol.LABORATORISTA) {
            modificarResultadoButton.setVisible(false);
            eliminarResultadoButton.setVisible(false);
        }
        nuevoResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoResultado dialog = new FrmNuevoResultado();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        modificarResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarResultado dialog = new FrmModificarResultado((ResultadoPeticionDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        eliminarResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoPeticionDTO resultadoPeticionDTO = (ResultadoPeticionDTO) comboBox1.getSelectedItem();
                ControllerPeticiones.getInstancia().bajaResultados(resultadoPeticionDTO);
                asignarDatosCombo();
            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<ResultadoPeticionDTO> listaResultados = new ArrayList<ResultadoPeticionDTO>();
        for (ResultadoPeticionDTO resultadoPeticionDTO : ControllerPeticiones.getInstancia().getListaResultadosDTO())
            listaResultados.add(resultadoPeticionDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaResultados);
        comboBox1.setModel(modelo);
    }
}
