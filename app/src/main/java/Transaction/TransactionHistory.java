/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author proteus
 */
public class TransactionHistory {
    private List<String> historialTransacciones; 
    private String numeroCuenta;

    public TransactionHistory(String numeroCuenta){
        this.numeroCuenta = numeroCuenta;
        this.historialTransacciones = new ArrayList<>();
    }
    
    public void registrarTransaccion(String transaccion) {
        historialTransacciones.add(transaccion);
    }
    
    public void mostrarHistorialTransacciones() {
        System.out.println("Historial de transacciones de la cuenta " + numeroCuenta + ":");
        for (String transaccion : historialTransacciones) {
            System.out.println(transaccion);
        }
    }
    
    public String consultarUltimoMovimiento() {
        if (!historialTransacciones.isEmpty()) {
            return historialTransacciones.get(historialTransacciones.size() - 1);
        } else {
            return "No hay movimientos registrados en esta cuenta.";
        }
    }
}
