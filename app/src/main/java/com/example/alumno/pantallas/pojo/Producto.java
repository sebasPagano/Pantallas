package com.example.alumno.pantallas.pojo;

/**
 * Created by Pagano on 01/05/2017.
 */

public class Producto {

    private String Nombre;
    private int ruta;
    private String tipoMenu;
    private double precio;
    private String imagen;


    public Producto(String nombre, double precio)
    {
        this.Nombre = nombre;
        this.precio = precio;
        //@drawable/usuario
    }
    public Producto(String nombre, double precio,int ruta)
    {
        this.Nombre = nombre;
        this.precio = precio;
        this.ruta = ruta;

        //@drawable/usuario
    }
    public Producto(String nombre,String tipoMenu,double precio,String imagen)
    {
        this.Nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.tipoMenu = tipoMenu;

        //@drawable/usuario
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {

        Nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        precio = precio;
    }

    public int getRuta()
    {
        return this.ruta;
    }

    public String getImagen() {
        return imagen;
    }
}
