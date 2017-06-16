package com.example.alumno.pantallas.pedido;

import com.example.alumno.pantallas.pojo.Listados;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ModeloPedido {

    public ModeloPedido()
    {

    }

    public boolean ListaNoEstaVacia()
    {
        if(Listados.listaProductoDelPedido.size() != 0)
        {
            return true;
        }
        return false;

    }


}
