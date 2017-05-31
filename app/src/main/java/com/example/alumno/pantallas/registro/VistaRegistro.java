package com.example.alumno.pantallas.registro;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import com.example.alumno.pantallas.R;

/**
 * Created by sepagano on 30/5/2017.
 */

public class VistaRegistro {

    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextDNI;
    EditText editTextMail;
    EditText editTextClave;
    EditText editTextReingreseClave;
    Button btnRegistro;
    Activity a;

    public VistaRegistro(Activity a)
    {
        this.a = a;
        editTextNombre = (EditText) a.findViewById(R.id.editTextNombre);
    }



}
