
package com.emergentes.modelo;


public class User {
 //atributos de clase 
    private int id;
    private String  nombre ;
    private String correo;
    private String clave;
    
   public User() {
        id = 0;
        nombre = "";
        correo = "";
        clave = "";
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
}
