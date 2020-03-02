/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author NELSON
 */
public class Servicio {
    public String codigo;
    public String nombre;
    public String responsable;
    public Double tarifa;
    ArrayList<Servicio> servicios= new ArrayList<>();
    public Servicio() {
    }

    public Servicio(String codigo,String nombre, String responsable, Double tarifa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.responsable = responsable;
        this.tarifa = tarifa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }
    
     public void registrarServicio(String cedula,String nombre, String responsable, Double tarifa){
        servicios.add(new Servicio(cedula,nombre,responsable,tarifa));
    }
    
    public String buscarServicio(String cedula){
//        int precio=0;
     for(int i=0; i<servicios.size();i++){
            if(cedula.equals(servicios.get(i).getCodigo())){
                return servicios.get(i).getCodigo();
            }
     }
//        System.out.println("Nada");
     return null;
    }
}
