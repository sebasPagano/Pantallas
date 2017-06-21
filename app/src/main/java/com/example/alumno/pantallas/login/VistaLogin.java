package com.example.alumno.pantallas.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
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
        View.OnClickListener listener = new MyListener(this);
        btnIngresar.setOnClickListener(listener);
        btnRegistrarme.setOnClickListener(listener);

    }
    public void ingresar()
    {
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
}
