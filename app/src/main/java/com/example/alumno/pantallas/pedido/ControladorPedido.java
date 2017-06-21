package com.example.alumno.pantallas.pedido;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.menu.Menu;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ControladorPedido {

    private MyListener listener;
    private ModeloPedido modeloPedido;
    private VistaPedido vistaPedido;
    private View v;


    public ControladorPedido(MyListener listener)
    {
        this.listener = listener;

    }

    public void irAMenu()
    {
        Context con = v.getContext();
        Intent i = new Intent(con, Menu.class);
        con.startActivity(i);
    }

    public void setView(View view)
    {
        this.v = view;
    }
    public MyListener getListener(){
        return this.listener;
    }
    public void setVistaPedido(VistaPedido vistaPedido) {
        this.vistaPedido = vistaPedido;
    }

    public void setModeloPedido(ModeloPedido modeloPedido) {
        this.modeloPedido = modeloPedido;
    }

}
