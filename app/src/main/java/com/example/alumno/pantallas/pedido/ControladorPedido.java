package com.example.alumno.pantallas.pedido;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.menu.Menu;
import com.example.alumno.pantallas.menu.ModeloMenu;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ControladorPedido {

    MyListener listener;
    ModeloPedido modeloPedido;
    VistaPedido vistaPedido;
    View v;
    public void setVistaPedido(VistaPedido vistaPedido) {
        this.vistaPedido = vistaPedido;
    }

    public void setModeloPedido(ModeloPedido modeloPedido) {
        this.modeloPedido = modeloPedido;
    }


    public ControladorPedido(MyListener listener)
    {
        this.listener = listener;

    }

    public MyListener getListener(){
        return this.listener;
    }

    public void setView(View view)
    {
        this.v = view;
    }
    public void irAMenu()
    {
            Context con = v.getContext();
            Intent i = new Intent(con, Menu.class);
            con.startActivity(i);

    }

}
