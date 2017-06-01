package com.example.alumno.pantallas.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.R;

import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ModeloRegistro modeloRegistro = new ModeloRegistro();
        VistaRegistro vistaRegistro =  new VistaRegistro(this,modeloRegistro);
        ControladorRegistro controladorRegistro = new ControladorRegistro(new MyListener(vistaRegistro));
    }


}
