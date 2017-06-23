package com.example.alumno.pantallas.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.R;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ModeloRegistro modeloRegistro = new ModeloRegistro();
        VistaRegistro vistaRegistro =  new VistaRegistro(this);
        ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro,modeloRegistro);
        vistaRegistro.setControladorRegistro(controladorRegistro);


    }


}
