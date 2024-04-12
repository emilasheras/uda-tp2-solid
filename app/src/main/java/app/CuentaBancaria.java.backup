import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;
    private List<String> historialTransacciones;
    private boolean cerrada;

    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.historialTransacciones = new ArrayList<>();
        this.cerrada = false;
        registrarTransaccion("Cuenta creada con saldo inicial de " + saldoInicial);
    }

    public void depositar(double cantidad) {
        if (!cerrada) {
            saldo += cantidad;
            registrarTransaccion("Depósito de " + cantidad + " realizado. Saldo actual: " + saldo);
        } else {
            System.out.println("No se puede depositar en una cuenta cerrada.");
        }
    }

    public void retirar(double cantidad) {
        if (!cerrada) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
                registrarTransaccion("Retiro de " + cantidad + " realizado. Saldo actual: " + saldo);
            } else {
                registrarTransaccion("Intento de retiro de " + cantidad + " fallido: saldo insuficiente.");
            }
        } else {
            System.out.println("No se puede retirar de una cuenta cerrada.");
        }
    }

    public void transferir(CuentaBancaria destino, double cantidad) {
        if (!cerrada) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
                destino.depositar(cantidad);
                registrarTransaccion("Transferencia de " + cantidad + " realizada a la cuenta " + destino.getNumeroCuenta());
            } else {
                registrarTransaccion("Intento de transferencia de " + cantidad + " fallido: saldo insuficiente.");
            }
        } else {
            System.out.println("No se puede transferir desde una cuenta cerrada.");
        }
    }

    public void mostrarHistorialTransacciones() {
        System.out.println("Historial de transacciones de la cuenta " + numeroCuenta + ":");
        for (String transaccion : historialTransacciones) {
            System.out.println(transaccion);
        }
    }

    public void cambiarTitular(String nuevoTitular) {
        if (!cerrada) {
            titular = nuevoTitular;
            System.out.println("Titular de la cuenta cambiado a: " + nuevoTitular);
        } else {
            System.out.println("No se puede cambiar el titular de una cuenta cerrada.");
        }
    }

    public String consultarUltimoMovimiento() {
        if (!historialTransacciones.isEmpty()) {
            return historialTransacciones.get(historialTransacciones.size() - 1);
        } else {
            return "No hay movimientos registrados en esta cuenta.";
        }
    }

    public void cerrarCuenta() {
        cerrada = true;
        System.out.println("Cuenta cerrada.");
    }

    public boolean estaCerrada() {
        return cerrada;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    private void registrarTransaccion(String transaccion) {
        historialTransacciones.add(transaccion);
    }

    public static void main(String[] args) {
        // Abrir una nueva cuenta
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan", "123456", 1000);

        // Realizar algunas operaciones
        cuenta1.depositar(500);
        cuenta1.retirar(200);
        cuenta1.transferir(cuenta1, 300); // Transferencia a sí mismo para evitar excepción
        cuenta1.transferir(cuenta1, 2000); // Intentar transferir más de lo que hay en la cuenta

        // Mostrar el saldo final y el historial de transacciones
        System.out.println("Saldo final de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo());
        cuenta1.mostrarHistorialTransacciones();

        // Cambiar el titular de la cuenta
        cuenta1.cambiarTitular("Pedro");

        // Consultar el último movimiento
        System.out.println("\nÚltimo movimiento: " + cuenta1.consultarUltimoMovimiento());

        // Cerrar la cuenta
        cuenta1.cerrarCuenta();

        // Intentar realizar operaciones en una cuenta cerrada
        cuenta1.depositar(100);
        cuenta1.retirar(50);
        cuenta1.transferir(cuenta1, 100);
    }
}
