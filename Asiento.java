/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lucho
 */
public class Asiento {
    private ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    private int cantTransacciones =0;
    private LocalDate fechaCreacionAsiento;
    private int numAsiento;
    
    
    public int getCantTransacciones() {
        return cantTransacciones;
    }

    public void setCantTransacciones(int cantTransacciones) {
        this.cantTransacciones = cantTransacciones;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }
    
    public Asiento(ArrayList<Transaccion> transacciones,LocalDate fecha,int numeroAsiento) {
        this.fechaCreacionAsiento = fecha;
        this.numAsiento = numeroAsiento;
        this.transacciones = transacciones;
        
        this.cantTransacciones = transacciones.size();
    }
    
    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public int getcantTransacciones() {
        return cantTransacciones;
    }

    public void setcantTransacciones(int cantAsientos) {
        this.cantTransacciones = cantAsientos;
    }

    public LocalDate getFecha() {
        return fechaCreacionAsiento;
    }

    public void setFecha(LocalDate fecha) {
        this.fechaCreacionAsiento = fecha;
    }
    
    
    
    
    
}
