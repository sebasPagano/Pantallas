package com.example.alumno.pantallas.login;

import android.util.Log;

import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Persona;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ModeloLogin {

    Listados listados;
    public ModeloLogin()
    {
        listados = Listados.getListados();
    }
    public boolean encontrarUsuario(String mail, String clave)
    {
        for(Persona pe : Listados.listaPersonas)
        {
            Log.d("hola",pe.toString());

            if(pe.getMail().toString().equals(mail) && pe.getClave().toString().equals(clave))
            {
                return true;
            }

        }

        return false;
    }


}
