package com.example.alumno.pantallas.pedido;

import com.example.alumno.pantallas.MyListener;

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


}
