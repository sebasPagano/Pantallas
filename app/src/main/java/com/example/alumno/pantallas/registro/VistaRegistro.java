package com.example.alumno.pantallas.registro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alumno.pantallas.ListenerAlert;
import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Persona;

/**
 * Created by sepagano on 30/5/2017.
 */

public class VistaRegistro {

    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextDNI;
    private EditText editTextMail;
    private EditText editTextClave;
    private EditText editTextReingreseClave;
    private Button btnRegistro;
    private View v;
    private Activity a;
    private ControladorRegistro controladorRegistro;

    public VistaRegistro(Activity a)
    {
        this.a = a;
        this.v = a.getLayoutInflater().inflate(R.layout.activity_main, null);
        editTextNombre = (EditText) a.findViewById(R.id.editTextNombre);
        editTextApellido = (EditText) a.findViewById(R.id.editTextApellido);
        editTextClave = (EditText) a.findViewById(R.id.editClave);
        editTextMail = (EditText) a.findViewById(R.id.editMail);
        editTextDNI = (EditText) a.findViewById(R.id.editTextDni);
        editTextReingreseClave = (EditText) a.findViewById(R.id.editTextReingrese);
        btnRegistro = (Button) a.findViewById(R.id.btnRegistrarse);
        View.OnClickListener listener = new MyListener(this);
        btnRegistro.setOnClickListener(listener);
    }
    public void Registrar()
    {
        String apellido = editTextApellido.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String clave = editTextClave.getText().toString();
        String reingreseClave = editTextReingreseClave.getText().toString();
        String mail = editTextMail.getText().toString();
        int dni;

        if(editTextDNI.getText().toString().equals("")) {
            dni = 0;
        }else
        {
            dni = Integer.parseInt(editTextDNI.getText().toString());
        }

        if(clave.equals(reingreseClave)) {

            controladorRegistro.volverAlLogin(v,nombre,apellido,dni,clave,mail);
        }else
        {
            String alerta = a.getString(R.string.alerta);
            String aceptar = a.getString(R.string.aceptar);
            String mensajeError = a.getString(R.string.mensajeErrorClaves);

            AlertDialog.Builder builder = new AlertDialog.Builder(a);
            builder.setTitle(alerta+"!!!");
            builder.setMessage(mensajeError);
            ListenerAlert l = new ListenerAlert();
            builder.setPositiveButton(aceptar, l);
            AlertDialog ad = builder.create();
            ad.show();
        }
        if(!controladorRegistro.isValida() && clave.equals(reingreseClave))
        {
            String alerta = a.getString(R.string.alerta);
            String aceptar = a.getString(R.string.aceptar);
            String mensajeError = a.getString(R.string.mensajeErrorRegistro);

            AlertDialog.Builder builder = new AlertDialog.Builder(a);
            builder.setTitle(alerta+"!!!");
            builder.setMessage(mensajeError);
            ListenerAlert l = new ListenerAlert();
            builder.setPositiveButton(aceptar, l);
            AlertDialog ad = builder.create();
            ad.show();
        }

    }

    public void setControladorRegistro(ControladorRegistro con)
    {
        this.controladorRegistro = con;
    }


}
