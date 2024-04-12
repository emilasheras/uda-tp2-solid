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
        CuentaBancaria cuenta1 = new CuentaBancaria(customerModel, "123456", 1000);
        System.out.println("cuenta1 creada.");
        System.out.println(cuenta1.estaCerrada());
        
        // Pruebas Generales sobre cuenta bancaria
        testGeneralAccOperations(cuenta1);

        // Pruebas sobre Mostrar el saldo final y el historial de transacciones
        testSaldoFinalAndHistorialTransacciones(cuenta1);

        // Pruebas sobre Cambiar el titular de la cuenta
        testCambiarTitular(cuenta1);

        // Pruebas sobre Historial de Transacciones
        testHistorialTransacciones(cuenta1);
        
        // Pruebas sobre Una cuenta Cerrada
        testCuentaCerrada(cuenta1);
    }
    
    private static void testGeneralAccOperations(CuentaBancaria cuenta){
        // Realizar algunas operaciones
        cuenta.depositar(500);
        cuenta.retirar(200);
        cuenta.transferir(cuenta, 300); // Transferencia a sí mismo para evitar excepción
        cuenta.transferir(cuenta, 2000); // Intentar transferir más de lo que hay en la cuenta
    }
    
    private static void testSaldoFinalAndHistorialTransacciones(CuentaBancaria cuenta){
        System.out.println("Saldo final de la cuenta " + cuenta.getNumeroCuenta() + ": " + cuenta.getSaldo());
        cuenta._transactionHistory.mostrarHistorialTransacciones();
    }
    
    private static void testCambiarTitular(CuentaBancaria cuenta){
        Customer customerModel = new Customer("Pedro"); // <- hardcoded values are somewhat acceptable in test cases, thats why i did SRP like this
        cuenta.cambiarTitular(customerModel);
        // expect? no crashes
    }
    
    private static void testHistorialTransacciones(CuentaBancaria cuenta){
        // Consultar el último movimiento
        System.out.println("\nÚltimo movimiento: " + cuenta._transactionHistory.consultarUltimoMovimiento());
        // expect? no crashes
    }
    
    private static void testCuentaCerrada(CuentaBancaria cuenta){
        System.out.println("\nPRUEBAS SOBRE CUENTA CERRADA");
        
        // Cerrar la cuenta
        cuenta.cerrarCuenta();

        // Intentar realizar operaciones en una cuenta cerrada
        cuenta.depositar(100);
        cuenta.retirar(50);
        cuenta.transferir(cuenta, 100);
        // expect? no crashes
    }

}
