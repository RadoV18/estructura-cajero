package bo.edu.ucb.est;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Cajero {

    private ArrayList<Cliente> clientesRegistrados;
    private Cliente clienteActual;

    public Cajero() {
        clientesRegistrados = new ArrayList<Cliente>();
        clienteActual = null;
    }

    public void setClienteActual(Cliente c) {
        this.clienteActual = c;
    }

    public void addCliente(Cliente... clientes) {
        for(Cliente c : clientes) {
            clientesRegistrados.add(c);
        }
    }

    public Cliente getCliente(String codigoCliente, String codigoSeguridad) {
        for(Cliente c : clientesRegistrados) {
            if(c.getCodigoCliente().equals(codigoCliente) && c.getPin().equals(codigoSeguridad)) {
                return c;
            }
        }
        return null;
    }

    public void ingreso() {
        Scanner input = new Scanner(System.in);
        String codigoCliente;
        String codigoSeguridad;
        while(true) {
            try {
                System.out.print("Ingrese su código de cliente: ");
                codigoCliente = input.nextLine();
                System.out.print("Ingrese su PIN de seguridad: ");
                codigoSeguridad = input.nextLine();
                if(codigoSeguridad.length() != 4) {
                    throw new Exception("El PIN de seguridad debe contener cuatro números.");
                }
                clienteActual = getCliente(codigoCliente, codigoSeguridad);
                if(clienteActual != null) {
                    menuPrincipal();
                } else {
                    throw new Exception("El código de cliente y/o el PIN son incorrectos.");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void menuPrincipal() {
        Scanner input = new Scanner(System.in);
        int opc;
        int cta;
        System.out.println("\n\nBienvenido/a, " + clienteActual.getNombre() + ".");
        while (true) {
            try {
                System.out.println("\n==============================================");
                System.out.println("\t\tMenú Principal");
                System.out.println("==============================================");
                System.out.println("\n1. Consultar Saldo");
                System.out.println("2. Realizar un retiro");
                System.out.println("3. Realizar un depósito");
                System.out.println("4. Salir");
                System.out.println("\n==============================================");
                System.out.print("Ingrese una opción: ");
                opc = input.nextInt();
                if(opc <= 0 || opc > 4) {
                    throw new InputMismatchException();
                }
                if(opc == 4) {
                    setClienteActual(null);
                    ingreso();
                } else {
                    try {
                        System.out.print("Ingrese el número de cuenta: ");
                        cta = input.nextInt();
                        Cuenta c = clienteActual.getCuenta(cta);
                        if(c != null) {
                            if(opc == 1) {
                                c.mostrarSaldo();
                                System.out.print("Pulse Enter para volver al menú principal.");
                                input.nextLine();
                                input.nextLine();
                            } else  {
                                if(opc == 2) {
                                    System.out.print("Ingrese el monto a retirar: ");
                                } else {
                                    System.out.print("Ingrese el monto a depositar: ");
                                }
                                try {
                                    int monto = input.nextInt();
                                    if(monto <= 0) {
                                        throw new Exception("Ingrese un monto válido.");
                                    }
                                    c.realizarTransaccion(opc == 2 ? -monto : monto);
                                    System.out.println("Transacción realizada.\nPulse Enter para continuar.");
                                    input.nextLine();
                                    input.nextLine();
                                } catch (InputMismatchException e) {
                                    System.err.println("El monto debe contener números.");
                                    input.nextLine();
                                } catch (Exception e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                        } else {
                            throw new Exception("Cuenta no encontrada.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("La cuenta debe contener números");
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }                    
                }
            } catch (InputMismatchException e) {
                System.err.println("\nIngrese una opción válida.");
                input.nextLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
