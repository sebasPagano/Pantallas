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

    private EditText editTextMail;
    private EditText editTextClave;
    private Button btnIngresar;
    private Button btnRegistrarme;
    private Activity a;
    private ControladorLogin controladorLogin;
    private ModeloLogin modelo;
    private View v;
    private View vR;
    private CheckBox checkBox;
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

        SharedPreferences prefs = a.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        boolean datoStr = prefs.getBoolean("recordarme",false);
        //la base de datos al ser una lista, estos datos se mantendran en memoria pero no en la lista
        //asi que al ingresar denuevo en la aplicacion recordara al usuario pero no te permitira logiar
        //dado que no se encuentra en dicha lista.
        if(datoStr==true) {
            String mail = prefs.getString("correo","default_value");
            String clave= prefs.getString("clave","default_value");
             editTextMail.setText(mail);
             editTextClave.setText(clave);
        }

    }
    public void ingresar()
    {
        controladorLogin.setA(a);
        controladorLogin.irMenu(this.v,editTextMail.getText().toString(),editTextClave.getText().toString());


        if(!controladorLogin.isTieneAcceso())
        {
            this.MostrarMensajeError();
        }
    }

    public void MostrarMensajeError()
    {
        String alerta = a.getString(R.string.alerta);
        String aceptar = a.getString(R.string.aceptar);
        String mensajeError = a.getString(R.string.mensajeErrorLogin);

        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle(alerta+"!!!");
        builder.setMessage(mensajeError);
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar, l);
        AlertDialog ad = builder.create();
        ad.show();
    }

    public void registrar() {

        controladorLogin.irRegistrar(this.vR);
    }
    public void setControladorLogin(ControladorLogin con)
    {
        this.controladorLogin = con;
    }

    public boolean getValidaCheckbox() {
        return checkBox.isChecked();
    }
}
