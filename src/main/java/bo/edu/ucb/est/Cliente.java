package bo.edu.ucb.est;
import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String codigoCliente;
    //String para permitir que se ingrese 0000
    private String pin;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, String codigoCliente, String pin) {
        this.nombre = nombre;
        this.codigoCliente = codigoCliente;
        this.pin = pin;
        this.cuentas = new ArrayList<Cuenta>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getPin() {
        return pin;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public Cuenta getCuenta(int numCuenta) {
        for(Cuenta c : cuentas) {
            if(c.getCodigo() == numCuenta) {
                return c;
            }
        }
        return null;
    }

    public void addCuenta(Cuenta... cuentasNuevas) {
        for(Cuenta c : cuentasNuevas) {
            cuentas.add(c);
        }
    }
}
