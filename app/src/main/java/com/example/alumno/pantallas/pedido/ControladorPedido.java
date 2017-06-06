package com.example.alumno.pantallas.pedido;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.menu.Menu;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ControladorPedido {

    MyListener listener;
    public ControladorPedido(MyListener listener)
    {
        this.listener = listener;

    }

    public MyListener getListener(){
        return this.listener;
    }

    public void irAMenu(View v)
    {
        Context con = v.getContext();
        Intent i = new Intent(con, Menu.class);
        con.startActivity(i);

    }

}
