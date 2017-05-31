package com.example.alumno.pantallas.pojo;

/**
 * Created by Pagano on 01/05/2017.
 */

public class Pedido {




    private String Nombre;


    private int Precio;

    public Pedido(String nombre, int precio)
    {
        this.Nombre = nombre;
        this.Precio = precio;
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


}
