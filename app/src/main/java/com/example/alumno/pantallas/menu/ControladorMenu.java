package com.example.alumno.pantallas.menu;

import android.app.Activity;

import com.example.alumno.pantallas.MyListener;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ControladorMenu {

    MyListener listener;
    public ControladorMenu(MyListener listener)
    {
        this.listener = listener;

    }

    public MyListener getListener(){
        return this.listener;
    }


}
