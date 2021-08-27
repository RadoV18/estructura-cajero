package bo.edu.ucb.est;

public class App {
    public static void main(String[] args) {

        Cajero ca = new Cajero();

        Cliente c1 = new Cliente("Juan Perez", "jperez", "3333");
        Cliente c2 = new Cliente("Maria Gomez", "mgomez", "4444");
        //TODO corregir nombre
        Cliente c3 = new Cliente("Juan Perez", "jperez", "3333");

        Cuenta cu1 = new Cuenta(111122, true, Cuenta.CAJA_AHORROS, 12000);
        Cuenta cu2 = new Cuenta(112211, false, Cuenta.CUENTA_CORRIENTE, 100);
        Cuenta cu3 = new Cuenta(221122, true, Cuenta.CAJA_AHORROS, 0);
        Cuenta cu4 = new Cuenta(331122, true, Cuenta.CAJA_AHORROS, 100);
        Cuenta cu5 = new Cuenta(332211, false, Cuenta.CUENTA_CORRIENTE, 1000);
        Cuenta cu6 = new Cuenta(332233, true, Cuenta.CAJA_AHORROS, 100000);

        c1.addCuenta(cu1, cu2);
        c2.addCuenta(cu3);
        c3.addCuenta(cu4, cu5, cu6);

        ca.addCliente(c1, c2, c3);
        ca.ingreso();
    }
}
