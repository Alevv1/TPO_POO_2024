package vista;

import DTO.PeticionesDTO;
import DTO.ResultadoPeticionDTO;
import controller.ControllerPeticiones;

import javax.swing.*;

public class FrmMostrarResultadosNumerico extends JDialog {
    private JPanel pnlPrincipal;
    private JLabel ID;
    private JLabel ValorNumerico;
    private JLabel ValorBooleano;
    private JLabel numerico;
    private JLabel booleano;

    public FrmMostrarResultadosNumerico(PeticionesDTO peticionesDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        for (ResultadoPeticionDTO resultadoPeticionDTO : ControllerPeticiones.getInstancia().listaResultadosDTO)
            if (resultadoPeticionDTO.ID == peticionesDTO.resultadoDTO) {
                ValorNumerico.setText(String.valueOf(resultadoPeticionDTO.valorNumerico));
                ID.setText(String.valueOf(resultadoPeticionDTO.ID));
            }

    }
}
