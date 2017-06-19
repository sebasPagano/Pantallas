package com.example.alumno.pantallas.pojo;

/**
 * Created by Pagano on 01/05/2017.
 */

public class Producto {

    private String Nombre;
    private int Precio;
    private int ruta;
    private String tipoMenu;
    private double precio2;
    private String imagen;


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
    public Producto(String nombre,String tipoMenu,double precio,String imagen)
    {
        this.Nombre = nombre;
        this.precio2 = precio;
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

    public double getPrecio2() {
        return precio2;
    }

    public String getImagen() {
        return imagen;
    }
}
