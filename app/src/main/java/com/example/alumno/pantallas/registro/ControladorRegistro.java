package com.example.alumno.pantallas.registro;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.View;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Persona;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorRegistro {

    MyListener listener;
    ModeloRegistro modelo;
    public ControladorRegistro(MyListener listener)
    {
        this.listener = listener;

    }

    public MyListener getListener(){
        return this.listener;
    }

    public boolean Validar(String nombre, String apellido, int dni, String clave, String mail)
    {
        if(nombre!=null && apellido!=null && dni>10000000 && clave!=null && mail!=null) {
            return true;
        }
        return false;
    }

    public void volverAlLogin(View v, String nombre, String apellido, int dni, String clave, String mail)
    {
        boolean valida = this.Validar(nombre,apellido,dni,clave,mail);

        if(valida) {
            modelo.agregarUsuario(new Persona(nombre,apellido,dni,mail,clave));
            Context con = v.getContext();
            Intent i = new Intent(con, MainActivity.class);
            con.startActivity(i);
            }
    }

    public void setModeloRegistro(ModeloRegistro modelo)
    {
        this.modelo = modelo;
    }


}