/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.NotasCrud;
/**
 *
 * @author HP
 */
public class Notas {
    NotasCrud nc = new NotasCrud();
    private int idNota;
    private String nota;
    private String edoAnimo;
    private String fecha;
    
    public Notas(){
        idNota = 0;
        nota = fecha = " ";
        
    }

    public NotasCrud getNc() {
        return nc;
    }

    public void setNc(NotasCrud nc) {
        this.nc = nc;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEdoAnimo() {
        return edoAnimo;
    }

    public void setEdoAnimo(String edoAnimo) {
        this.edoAnimo = edoAnimo;
    }


    public boolean alta(){
        return nc.crear(this);
    }
    
}
