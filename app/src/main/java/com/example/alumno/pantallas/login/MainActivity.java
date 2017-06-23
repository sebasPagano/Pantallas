package com.example.alumno.pantallas.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.otros.ThreadConexion;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pojo.Producto;

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
        ControladorLogin controladorLogin = new ControladorLogin(vista,modeloLogin,this);
        vista.setControladorLogin(controladorLogin);



    }

}
