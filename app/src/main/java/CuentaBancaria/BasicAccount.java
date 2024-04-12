/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuentaBancaria;

/**
 *
 * @author proteus
 */
public abstract class BasicAccount implements BasicAccountInterface{
    protected String numeroCuenta;
    protected double saldo;
    protected boolean cerrada;
    
    protected String titular; // El string del nombre del titular. deberia venir de un objeto de una clase de Titular/Customer
    protected int customerId;
    
    @Override
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String getTitular() {
        return titular;
    }
    
    @Override
    public boolean estaCerrada(){
        return cerrada;
    }
    
    @Override
    public void cerrarCuenta() {
        cerrada = true;
        System.out.println("Cuenta cerrada.");
    }
}
