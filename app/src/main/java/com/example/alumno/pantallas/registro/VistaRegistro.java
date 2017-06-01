package com.example.alumno.pantallas.registro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private Activity a;
    private ModeloRegistro modelo;

    public VistaRegistro(Activity a, ModeloRegistro modelo)
    {
        this.a = a;
        editTextNombre = (EditText) a.findViewById(R.id.editTextNombre);
        editTextApellido = (EditText) a.findViewById(R.id.editTextApellido);
        editTextClave = (EditText) a.findViewById(R.id.editClave);
        editTextMail = (EditText) a.findViewById(R.id.editMail);
        editTextDNI = (EditText) a.findViewById(R.id.editTextDni);
        editTextReingreseClave = (EditText) a.findViewById(R.id.editTextReingrese);
        btnRegistro = (Button) a.findViewById(R.id.btnRegistrarse);
        View.OnClickListener listener = new MyListener(this);
        btnRegistro.setOnClickListener(listener);
        this.modelo = modelo;
    }
    public void Registrar(View v)
    {
        String apellido = editTextApellido.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String clave = editTextClave.getText().toString();
        String reingreseClave = editTextReingreseClave.getText().toString();
        String mail = editTextMail.getText().toString();
        int dni = Integer.parseInt(editTextDNI.getText().toString());

        if(clave.equals(reingreseClave)) {

            boolean valida = ControladorRegistro.Validar(nombre,apellido,dni,clave,mail);

            if(valida) {
                modelo.agregarUsuario(new Persona(nombre,apellido,dni,mail,clave));
                Log.d("Registrarme", "registro");
                Context con = v.getContext();
                Intent i = new Intent(con, MainActivity.class);
                con.startActivity(i);
            }
        }else
        {
            Log.d("INCORRECTO", "Las claves son distintas");
        }
    }



}
