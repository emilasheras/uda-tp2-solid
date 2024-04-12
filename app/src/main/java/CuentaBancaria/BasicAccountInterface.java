/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CuentaBancaria;

/**
 *
 * @author proteus
 */
public interface BasicAccountInterface {
    // Getters & Setters
    String getNumeroCuenta();
    void setNumeroCuenta(String numeroCuenta);
    double getSaldo();
    String getTitular();
    
    // Methods & Functions
    void depositar(double cantidad);
    void retirar(double cantidad);
    void cerrarCuenta();
    boolean estaCerrada();
}