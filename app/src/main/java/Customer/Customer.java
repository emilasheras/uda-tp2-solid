/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author proteus
 */
public class Customer {
    private int customerId; // PK
    private String name; // (titular ahora va a venir de este atributo)
    
    public Customer(String name){
        this.customerId = getNextCustomerId();
        this.name = name;
        //...
    }
    
    public String getName(){
        return this.name;
    }
    
    // todo: get from a singleton manager instance. place it in the same pkg
    public int getNextCustomerId(){
        return 1;
    }
}
