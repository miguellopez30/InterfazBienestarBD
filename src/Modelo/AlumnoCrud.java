/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controlador.Alumno;
/**
 *
 * @author HP
 */
public class AlumnoCrud {
    ConexionBD cx = new ConexionBD();
    
    
    
    public ResultSet ReportGen(){
    ResultSet rs = null;
    PreparedStatement ps = null;
    String sql = "SELECT * FROM alumno";
    try{
        ps = cx.conecta().prepareStatement(sql);
    rs = ps.executeQuery();
    
    }
    catch(SQLException ex){
        System.out.println("Error " + ex.getMessage());
    }
     return rs;
    }
    public boolean crear(Alumno a){
        boolean b = true;
        ConexionBD cbd = new ConexionBD();
        String sql = "Insert Into alumno (nombre, app, apm, sexo, edad) Values (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = cbd.conecta().prepareStatement(sql);   
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getPaterno());
            ps.setString(3, a.getMaterno());
            ps.setString(4, a.getSexo());
            ps.setInt(5, a.getEdad());
            b = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}