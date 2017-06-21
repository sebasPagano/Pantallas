package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.pedido.Pedidos;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ControladorMenu {

    MyListener listener;
    ModeloMenu modeloMenu;
    View v;
    public ControladorMenu(MyListener listener)
    {
        this.listener = listener;

    }

    public void setView(View view)
    {
        this.v = view;
    }

    public MyListener getListener(){
        return this.listener;
    }

    public void setModeloMenu(ModeloMenu modelo)
    {
        this.modeloMenu = modelo;
    }
    public void irAPedido()
    {
        if(modeloMenu.ListaNoEsNull() == true) {
            Context con = v.getContext();
            Intent i = new Intent(con, Pedidos.class);
            con.startActivity(i);
        }
    }

}
