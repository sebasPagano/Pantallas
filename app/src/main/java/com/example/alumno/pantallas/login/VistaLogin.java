package com.example.alumno.pantallas.login;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;

/**
 * Created by sepagano on 30/5/2017.
 */

public class VistaLogin {

    private EditText editTextMail;
    private EditText editTextClave;
    private Button btnIngresar;
    private Button btnRegistrarme;
    private Activity a;
    private ControladorLogin controladorLogin;
    private ModeloLogin modelo;
    public VistaLogin(Activity a)
    {
        this.a = a;

        editTextMail = (EditText) a.findViewById(R.id.EditMailLogin);
        editTextMail.setText("seba@hotmail.com");
        editTextClave = (EditText) a.findViewById(R.id.editClave);
        editTextClave.setText("123123");
        btnIngresar =(Button) a.findViewById(R.id.btnIngresar);
        btnRegistrarme =(Button) a.findViewById(R.id.btnRegistro);
        View.OnClickListener listener = new MyListener(this);
        btnIngresar.setOnClickListener(listener);
        btnRegistrarme.setOnClickListener(listener);

    }
    public void ingresar(View v)
    {
        controladorLogin.irMenu(v,editTextMail.getText().toString(),editTextClave.getText().toString());
    }


    public void registrar(View v) {

        controladorLogin.irRegistrar(v);
    }
    public void setControladorLogin(ControladorLogin con)
    {
        this.controladorLogin = con;
    }
}
