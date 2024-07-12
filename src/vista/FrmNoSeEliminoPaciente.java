package vista;

import javax.swing.*;

public class FrmNoSeEliminoPaciente extends JDialog{
    private JPanel pnlPrincipal;
    public FrmNoSeEliminoPaciente() {
        setSize(300, 200);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
