package com.example.alumno.pantallas.pojo;

import android.graphics.Bitmap;

/**
 * Created by Pagano on 01/05/2017.
 */

public class Producto {

    private String Nombre;
    private int ruta;
    private String tipoMenu;
    private double precio;
    private String imagen;
    private Bitmap bitmap;


    public Producto(String nombre,String tipoMenu,double precio,String imagen)
    {
        this.Nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.tipoMenu = tipoMenu;

        //@drawable/usuario
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public String getImagen() {
        return imagen;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
