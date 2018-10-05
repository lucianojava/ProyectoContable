/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Lucho
 */
public class Transaccion implements Comparable<Transaccion>{
    private boolean debeHaber;  // true es debe y false es haber
    private LocalDate fecha;
    private String concepto;
    private int numAsiento;
    private int monto;
    private int codigoNumerico;  // Numero de cuenta

    public int getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(int codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public boolean isDebeHaber() {
        return debeHaber;
    }
    
    public Transaccion(boolean debeHaber, LocalDate fecha, String concepto,int monto, int numAsiento,int codigo) {
        this.debeHaber = debeHaber;
        this.fecha = fecha;
        this.concepto = concepto;
        this.numAsiento = numAsiento;
        this.monto = monto;
        this.codigoNumerico = codigo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean getDebeHaber() {
        return debeHaber;
    }

    public void setDebeHaber(boolean debeHaber) {
        this.debeHaber = debeHaber;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public int getNumAsiento() {
        return numAsiento;
    }
    
    @Override
    public int compareTo(Transaccion o2) {     //ANDA para que ande el .sort() del arraylist
        if(this.getFecha().isBefore(o2.getFecha())){
            return -1;
        }
        else if(this.getFecha().isAfter(o2.getFecha())){
            return 1;
        }
        else{
            return 0;
        }
        
    }
    
}
