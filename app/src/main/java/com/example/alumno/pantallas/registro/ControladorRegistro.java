package com.example.alumno.pantallas.registro;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Display;
import android.view.View;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Persona;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorRegistro {

    private MyListener listener;
    private ModeloRegistro modelo;
    private boolean valida;
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
        valida = this.Validar(nombre,apellido,dni,clave,mail);
        Log.d("valida","validaa"+valida);
        if(valida) {
            Log.d("valida","validaa"+valida);
            modelo.agregarUsuario(new Persona(nombre,apellido,dni,mail,clave));
            Context con = v.getContext();
            Intent i = new Intent(con, MainActivity.class);
            con.startActivity(i);
            }
            else
            {
                Log.d("valida","no validaa"+valida);
            }
    }

    public boolean isValida() {
        return valida;
    }

    public void setModeloRegistro(ModeloRegistro modelo)
    {
        this.modelo = modelo;
    }


}