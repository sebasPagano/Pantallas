package com.example.alumno.pantallas.pojo;

/**
 * Created by Pagano on 01/05/2017.
 */

public class Producto {

    private String Nombre;
    private int Precio;
    private int ruta;

    public Producto(String nombre, int precio)
    {
        this.Nombre = nombre;
        this.Precio = precio;
        //@drawable/usuario
    }
    public Producto(String nombre, int precio,int ruta)
    {
        this.Nombre = nombre;
        this.Precio = precio;
        this.ruta = ruta;

        //@drawable/usuario
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {

        Nombre = nombre;
    }
    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public int getRuta()
    {
        return this.ruta;
    }



}
