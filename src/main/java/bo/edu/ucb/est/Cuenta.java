package bo.edu.ucb.est;

public class Cuenta {

    public static final String[] tiposCuenta = {"Caja de Ahorro", "Cuenta Corriente"};
    public static final int CAJA_AHORROS = 0;
    public static final int CUENTA_CORRIENTE = 1;

    private int codigo;
    private boolean enBolivianos;
    private String tipo;
    private int saldoDisponible;

    public Cuenta(int codigo, boolean enBolivianos, int tipo, int saldoDisponible) {
        this.codigo = codigo;
        this.enBolivianos = enBolivianos;
        this.tipo = tiposCuenta[tipo];
        this.saldoDisponible = saldoDisponible;
    }

    public int getCodigo() {
        return codigo;
    }

    public void mostrarSaldo() {
        System.out.println("\nCuenta número: " + codigo);
        System.out.println("Moneda: " + (enBolivianos ? "Bolivianos" : "Dólares"));
        System.out.println("Tipo: " + tipo);
        System.out.println("Saldo disponible: " + saldoDisponible + (enBolivianos ? " Bs.\n" : " USD\n"));
    }

    public void realizarTransaccion(int monto) throws Exception {
        if(monto == 0) {
            throw new Exception("El monto debe ser distinto de cero.");
        }
        if(monto % 10 != 0) {
            throw new Exception("El monto debe ser múltiplo de diez.");
        }
        if(monto < 0 && Math.abs(monto) > saldoDisponible) {
            throw new Exception("Saldo insuficiente.");
        }
        saldoDisponible += monto;
    }

}
