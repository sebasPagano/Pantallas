package com.example.alumno.pantallas.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.R;

import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        List<Persona> listaPersonas = new ArrayList<>();

        Persona p1 = new Persona("Sebastian","Pagano",40253335,"seba@hotmail.com","asdasd");

        TextView nombre = (TextView) findViewById(R.id.textViewNombre);
        Log.d("hola",(String)nombre.getText());

    }
}
