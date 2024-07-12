import controller.ControllerUsuarios;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import vista.FrmLogin;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        ControllerSucursal.getInstancia();
        ControllerUsuarios.getInstancia();
        ControllerPeticiones.getInstancia();
        FrmLogin win = new FrmLogin();
        win.setVisible(true);
    }
}
