package com.example.alumno.pantallas.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.registro.ControladorRegistro;
import com.example.alumno.pantallas.registro.ModeloRegistro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Listados listados = Listados.getListados();
        Listados.listaProductoDelPedido.clear();
        ModeloLogin modeloLogin = new ModeloLogin();
        VistaLogin vista = new VistaLogin(this);
        ControladorLogin controladorLogin = new ControladorLogin(new MyListener(vista));
        controladorLogin.setModeloLogin(modeloLogin);
        vista.setControladorLogin(controladorLogin);
    }
}
