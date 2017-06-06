package com.example.alumno.pantallas;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.alumno.pantallas.login.VistaLogin;
import com.example.alumno.pantallas.menu.VistaMenu;
import com.example.alumno.pantallas.pedido.Pedidos;
import com.example.alumno.pantallas.pedido.VistaPedido;
import com.example.alumno.pantallas.registro.VistaRegistro;

/**
 * Created by Pagano on 03/05/2017.
 */

public class MyListener implements View.OnClickListener {

    Activity a;
    FragmentManager fr;
    VistaLogin vistaLogin;
    VistaRegistro vistaRegistro;
    VistaMenu vistaMenu;
    VistaPedido vistaPedido;
    public MyListener(Activity ac)
    {
        this.a = ac;

    }

    public MyListener(VistaLogin v)
    {
        this.vistaLogin = v;
    }
    public MyListener(VistaRegistro v)
    {
        this.vistaRegistro = v;
    }
    public MyListener(VistaMenu v)
    {
        this.vistaMenu = v;
    }
    public MyListener(VistaPedido v)
    {
        this.vistaPedido = v;
    }




    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.btnIngresar) {
            vistaLogin.ingresar(v);
        }
        if(v.getId() == R.id.btnRegistro) {

            vistaLogin.registrar(v);
        }
        if(v.getId() == R.id.btnEnviarPedido)
        {
            vistaMenu.enviandoPedido(v);
        }
        if(v.getId() == R.id.AceptarPedido2)
        {
            vistaPedido.MostrarMensaje(v);
        }
        if(v.getId() == R.id.btnRegistrarse)
        {

            vistaRegistro.Registrar(v);
        }

    }


}
