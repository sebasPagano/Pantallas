package com.example.alumno.pantallas.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.menu.Menu;
import com.example.alumno.pantallas.registro.Registro;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorLogin {

    private MyListener listener;
    private  ModeloLogin modeloLogin;
    public ControladorLogin(MyListener listener)
    {
        this.listener = listener;
    }
    public void setModeloLogin(ModeloLogin m)
    {
        this.modeloLogin = m;
    }

    public MyListener getListener(){
        return this.listener;
    }


    public void irRegistrar(View v) {
        Context con = v.getContext();
        Intent i = new Intent(con, Registro.class);
        con.startActivity(i);
    }

    public void irMenu(View v, String mail,String clave){

        if(modeloLogin.encontrarUsuario(mail,clave)) {
            Context con = v.getContext();
            Intent i = new Intent(con, Menu.class);
            con.startActivity(i);
        }
    }



}
