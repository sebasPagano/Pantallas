package com.example.alumno.pantallas.registro;

import com.example.alumno.pantallas.MyListener;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorRegistro {

    MyListener listener;
    public ControladorRegistro(MyListener listener)
    {
        this.listener = listener;

    }

    public MyListener getListener(){
        return this.listener;
    }

    public static boolean Validar(String nombre, String apellido, int dni, String clave, String mail)
    {
        if(nombre!=null && apellido!=null && dni>10000000 && clave!=null && mail!=null) {
            return true;
        }
        return false;
    }

}
