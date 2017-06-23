package com.example.alumno.pantallas.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.alumno.pantallas.otros.ListenerAlert;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.R;

/**
 * Created by sepagano on 30/5/2017.
 */

public class VistaLogin {

    public EditText editTextMail;
    public EditText editTextClave;
    private Button btnIngresar;
    private Button btnRegistrarme;
    private Activity a;
    private ControladorLogin controladorLogin;
    private ModeloLogin modelo;
    private View v;
    private View vR;
    public CheckBox checkBox;
    public VistaLogin(Activity a)
    {
        this.a = a;
        this.v = a.getLayoutInflater().inflate(R.layout.activity_menu, null);
        this.vR = a.getLayoutInflater().inflate(R.layout.activity_registro, null);
        editTextMail = (EditText) a.findViewById(R.id.EditMailLogin);
        editTextMail.setText("seba@hotmail.com");
        editTextClave = (EditText) a.findViewById(R.id.editClave);
        editTextClave.setText("123123");
        btnIngresar =(Button) a.findViewById(R.id.btnIngresar);
        btnRegistrarme =(Button) a.findViewById(R.id.btnRegistro);
        checkBox = (CheckBox) a.findViewById(R.id.checkBox);
        View.OnClickListener listener = new MyListener(this);
        btnIngresar.setOnClickListener(listener);
        btnRegistrarme.setOnClickListener(listener);



    }
    public void ingresar()
    {

        controladorLogin.irMenu(this.v,editTextMail.getText().toString(),editTextClave.getText().toString());

    }

    public void registrar() {

        controladorLogin.irRegistrar(this.vR);
    }
    public void setControladorLogin(ControladorLogin con)
    {
        this.controladorLogin = con;
    }


}
