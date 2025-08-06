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
import Controlador.Notas;
/**
 *
 * @author HP
 */
public class NotasCrud {
    ConexionBD cx = new ConexionBD();
    
    
    
    public ResultSet ReportGen(){
    ResultSet rs = null;
    PreparedStatement ps = null;
    String sql = "SELECT * FROM nota";
    try{
        ps = cx.conecta().prepareStatement(sql);
    rs = ps.executeQuery();
    
    }
    catch(SQLException ex){
        System.out.println("Error " + ex.getMessage());
    }
     return rs;
    }
    public boolean crear(Notas a){
        boolean b = true;
        ConexionBD cbd = new ConexionBD();
        String sql = "Insert Into nota (nota, edoAnimo, fecha) Values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = cbd.conecta().prepareStatement(sql);   
            ps.setString(1, a.getNota());
            ps.setString(2, a.getEdoAnimo());
            ps.setString(3, a.getFecha());
            b = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NotasCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}