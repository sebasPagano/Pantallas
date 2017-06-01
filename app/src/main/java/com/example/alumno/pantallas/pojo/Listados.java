package com.example.alumno.pantallas.pojo;

import android.util.Log;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sepagano on 1/6/2017.
 */

public class Listados {

    private static Listados  listados;
    public static Set<Persona> listaPersonas;


    private Listados()
    {
        Log.d("inicializo","listado");
        listaPersonas = new HashSet<>();
        listaPersonas.add(new Persona("seba","pagano",40253335,"seba@hotmail.com","123123"));
    }
    public static Listados getListados()
    {
        if(listados ==null)
        {
            Log.d("entro en metodo","listado");
            listados = new Listados();
        }
        return listados;
    }


}
