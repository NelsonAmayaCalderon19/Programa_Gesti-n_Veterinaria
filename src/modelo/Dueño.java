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
public class Dueño {
    public String cedula;
    public String nombre;
    public String direccion;
    public String telefono;
    public String genero;
ArrayList<Dueño> dueños= new ArrayList<>();
    public Dueño() {
    }

    public Dueño(String cedula, String nombre, String direccion, String telefono, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void registrarDueño(String cedula, String nombre, String direccion, String telefono, String genero){
        dueños.add(new Dueño(cedula,nombre,direccion,telefono,genero));
    }
    
    public String buscarDueño(String cedula){
//        int precio=0;
     for(int i=0; i<dueños.size();i++){
            if(cedula.equals(dueños.get(i).getCedula())){
                return dueños.get(i).getCedula();
            }
     }
//        System.out.println("Nada");
     return null;
    }
}
