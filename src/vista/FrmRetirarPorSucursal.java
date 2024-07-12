package vista;

import javax.swing.*;

public class FrmRetirarPorSucursal extends JDialog{
    private JPanel pnlPrincipal;

    public FrmRetirarPorSucursal() {
        setSize(400, 200);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
