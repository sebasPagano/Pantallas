package com.example.alumno.pantallas.login;

import com.example.alumno.pantallas.MyListener;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorLogin {


    MyListener listener;
    public ControladorLogin(MyListener listener)
    {
        this.listener = listener;

    }

    public MyListener getListener(){
        return this.listener;
    }

}
