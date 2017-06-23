package com.example.alumno.pantallas.registro;

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

public class VistaRegistro {

    public EditText editTextNombre;
    public EditText editTextApellido;
    public EditText editTextDNI;
    public EditText editTextMail;
    public EditText editTextClave;
    public EditText editTextReingreseClave;
    private Button btnRegistro;
    public View v;
    public Activity a;
    private ControladorRegistro controladorRegistro;

    public VistaRegistro(Activity a)
    {
        this.a = a;
        this.v = a.getLayoutInflater().inflate(R.layout.activity_login, null);
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
    public void irARegistro()
    {
        controladorRegistro.Registrar();
    }

    public void setControladorRegistro(ControladorRegistro con)
    {
        this.controladorRegistro = con;
    }


}
