/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lucho
 */
public class SistemaGeneral {
    private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
    private Asiento asientoOficial;
    private ArrayList<Transaccion> transaccionesTemporales = new ArrayList<Transaccion>();

    
    
    public SistemaGeneral() {
    }
    
    public int numAsientos(){
        return asientos.size();
        
    }
    //<Transaccion> transacciones,LocalDate fecha,int numeroAsiento
    //(boolean debeHaber, LocalDate fecha, String concepto,int monto, int numAsiento,int codigo) 
    
    public void agregarTransaccion(boolean debeHaber,LocalDate fecha,String concepto,int  monto,int numA,int codigo){
        Transaccion transaccion= new Transaccion(debeHaber ,fecha ,concepto  ,monto ,numA ,codigo );
        transaccionesTemporales.add(transaccion);
        
        /*
        this.asientoOficial = new Asiento(transacciones,fecha,numeroAsiento);
        asientos.add(this.asientoOficial);
        */
    }
    
    
    public void agregarAsiento(LocalDate fechaAsiento,int numAsiento){
        Asiento asiento = new Asiento(this.getTransaccionesTemporales(),fechaAsiento,numAsiento);
        asientos.add(asiento);
        ArrayList<Transaccion> coleccion = new ArrayList<Transaccion>();
        this.setTransaccionesTemporales(coleccion); // Da problema
    }

    public Asiento getAsientoOficial() {
        return asientoOficial;
    }

    public void setAsientoOficial(Asiento asientoOficial) {
        this.asientoOficial = asientoOficial;
    }

    public ArrayList<Transaccion> getTransaccionesTemporales() {
        return transaccionesTemporales;
    }

    public void setTransaccionesTemporales(ArrayList<Transaccion> transaccionesTemporales) {
        this.transaccionesTemporales = transaccionesTemporales;
    }
        
    
    
    
    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }

    public Asiento getUltimoAsiento(){
        int cantidad = asientos.size();
        return this.getAsientos().get(cantidad -1);
    }

    public ArrayList<Transaccion> retornoFilasPorFechaDiario(LocalDate fechaDesde,LocalDate fechaHasta) {
        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        for (Asiento asientos : this.getAsientos()){
                for(Transaccion transac : asientos.getTransacciones()){
                    if (fechaDesde.isBefore(transac.getFecha().plusDays(1)) && fechaHasta.isAfter(transac.getFecha().minusDays(1)) ){
                        transacciones.add(transac);
                    }
                }
        }
        return transacciones;
    }

    public ArrayList<Transaccion> retornoFilasPorCuentaDiario(int codigo) {
        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        for (Asiento asientos : this.asientos){
            transacciones = asientos.getTransacciones();
            for(Transaccion transac : transacciones){
                if (codigo == transac.getCodigoNumerico()){
                    transacciones.add(transac);
                }
            }
        }
        return transacciones;
    }

    public ArrayList<Transaccion> retornoFilasVistaCompletaDiario() {
        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        for (Asiento asientos : this.asientos){
            for(Transaccion transac : asientos.getTransacciones()){
                transacciones.add(transac);
            }
        }
        return transacciones;
    }    

    public void crearAsiento() {
        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        String str = "05/10/2018";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        Transaccion transaccion= new Transaccion(true,dateTime,"Casa",500,5,30);
        transacciones.add(transaccion);
        Asiento asiento = new Asiento(transacciones,dateTime,1);
        asientos.add(asiento);
        
    }

    void limpiarTransaccionesTemporales() {
        transaccionesTemporales.clear();

    }

    public LocalDate fechaUltimoAsiento() {
        Asiento asiento = getUltimoAsiento();
        ArrayList<Transaccion> transac = asiento.getTransacciones();
        Transaccion transaccionFecha = transac.get(0);
        LocalDate fecha = transaccionFecha.getFecha();
        return fecha;
        
    }
    
    
    
    
}
    


