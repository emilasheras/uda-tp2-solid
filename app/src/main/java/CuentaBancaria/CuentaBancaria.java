package CuentaBancaria;

import Customer.Customer;
import Transaction.TransactionHistory;

public class CuentaBancaria extends BasicAccount {
    public TransactionHistory _transactionHistory; // (nuevo)
    public Customer _customerModel; // (nuevo)

    public CuentaBancaria(Customer customerModel, String numeroCuenta, double saldoInicial) {
        // Customer
        this.cambiarTitular(customerModel);
        
        // Cuenta Bancaria
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.cerrada = false; 

        // Transactions
        this._transactionHistory = new TransactionHistory(this.numeroCuenta);
        this._transactionHistory.registrarTransaccion("Cuenta creada con saldo inicial de " + saldoInicial);
    }
    
    private void cambiarTitular(Customer customerModel){

    }
    
    public void cambiarTitular(String nuevoTitular) {
        if (!cerrada) {
            //titular = nuevoTitular;
            
            this._customerModel = customerModel;
            this.titular = this._customerModel.getName();
            
            System.out.println("Titular de la cuenta cambiado a: " + nuevoTitular);
        } else {
            System.out.println("No se puede cambiar el titular de una cuenta cerrada.");
        }
    }

    public void depositar(double cantidad) {
        if (!cerrada) {
            saldo += cantidad;
            this._transactionHistory.registrarTransaccion("Depósito de " + cantidad + " realizado. Saldo actual: " + saldo);
        } else {
            System.out.println("No se puede depositar en una cuenta cerrada.");
        }
    }

    public void retirar(double cantidad) {
        if (!cerrada) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
                this._transactionHistory.registrarTransaccion("Retiro de " + cantidad + " realizado. Saldo actual: " + saldo);
            } else {
                this._transactionHistory.registrarTransaccion("Intento de retiro de " + cantidad + " fallido: saldo insuficiente.");
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
                this._transactionHistory.registrarTransaccion("Transferencia de " + cantidad + " realizada a la cuenta " + destino.getNumeroCuenta());
            } else {
                this._transactionHistory.registrarTransaccion("Intento de transferencia de " + cantidad + " fallido: saldo insuficiente.");
            }
        } else {
            System.out.println("No se puede transferir desde una cuenta cerrada.");
        }
    }
}
