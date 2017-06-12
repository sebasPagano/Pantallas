package com.example.alumno.pantallas.menu;

import com.example.alumno.pantallas.pojo.Listados;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ModeloMenu {
    public ModeloMenu()
    {

    }
    public boolean ListaNoEsNull()
    {
        if(Listados.listaProductoDelPedido.size() > 0)
        {
            return true;
        }
         return false;

    }
}
