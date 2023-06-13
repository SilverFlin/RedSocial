/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;


public class DAOException extends Exception {
    public DAOException(){
        
    }
    public DAOException(String n){
        super(n);
    }
    
    public DAOException(String n, Throwable t){
        super(n,t);
    }
    
    public DAOException(Throwable t){
        super(t);
    }
    
}
