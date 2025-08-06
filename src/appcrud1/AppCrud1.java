/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appcrud1;
import Modelo.ConexionBD;
import Vista.Mantenimiento;
/**
 *
 * @author HP
 */
public class AppCrud1 {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBD cbc = new ConexionBD();
    System.out.print(cbc.conecta());
    Mantenimiento m = new Mantenimiento();
    m.setVisible(true);
    }
    
}
