/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import Customer.Customer;
import CuentaBancaria.CuentaBancaria;

/**
 *
 * @author proteus
 */
public class App {
    public static void main(String[] args){
        // Buscar/Crear un cliente
        Customer customerModel = new Customer("Juan");
        
        // Abrir una nueva cuenta
        CuentaBancaria cuenta1 = new CuentaBancaria(customerModel, "123456", 1000);
        System.out.println("cuenta1 creada.");
        System.out.println(cuenta1.estaCerrada());
        
        // Realizar algunas operaciones
        cuenta1.depositar(500);
        cuenta1.retirar(200);
        cuenta1.transferir(cuenta1, 300); // Transferencia a sí mismo para evitar excepción
        cuenta1.transferir(cuenta1, 2000); // Intentar transferir más de lo que hay en la cuenta

        // Mostrar el saldo final y el historial de transacciones
        System.out.println("Saldo final de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo());
        cuenta1._transactionHistory.mostrarHistorialTransacciones();

        // Cambiar el titular de la cuenta
        cuenta1.cambiarTitular("Pedro");

        // Consultar el último movimiento
        System.out.println("\nÚltimo movimiento: " + cuenta1._transactionHistory.consultarUltimoMovimiento());

        // Cerrar la cuenta
        cuenta1.cerrarCuenta();

        // Intentar realizar operaciones en una cuenta cerrada
        cuenta1.depositar(100);
        cuenta1.retirar(50);
        cuenta1.transferir(cuenta1, 100);
    }

}
