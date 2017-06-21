package com.example.alumno.pantallas.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.menu.Menu;
import com.example.alumno.pantallas.registro.Registro;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorLogin {

    private MyListener listener;
    private  ModeloLogin modeloLogin;
    private boolean tieneAcceso;
    private Activity a;
    private VistaLogin vistaLogin;

    public ControladorLogin(MyListener listener)
    {
        this.listener = listener;
    }
    public void setModeloLogin(ModeloLogin m)
    {
        this.modeloLogin = m;
    }

    public boolean isTieneAcceso() {
        return tieneAcceso;
    }

    public void irRegistrar(View v) {
        Context con = v.getContext();
        Intent i = new Intent(con, Registro.class);
        con.startActivity(i);
    }

    public void irMenu(View v, String mail,String clave){
      tieneAcceso = modeloLogin.encontrarUsuario(mail,clave);
        if(tieneAcceso) {

            modeloLogin.almacenarDatos(a,mail,clave);
            Context con = v.getContext();
            Intent i = new Intent(con, Menu.class);
            con.startActivity(i);

        }
    }

    public void setA(Activity a) {
        this.a = a;
    }
}
