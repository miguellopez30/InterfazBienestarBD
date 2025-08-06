/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class ConexionBD {
    private final String url;
    private final String usuario;
    private final String password;
    
    public ConexionBD(){
        url = "jdbc:mysql://localhost:3306/usuario";
        usuario = "root";
        password = "";
    }
    public Connection conecta(){
        Connection cx=null;
    
        try {
            cx = DriverManager.getConnection(url,usuario,password);
            System.out.println("Si conecto la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        
        return cx;
    }

   

}