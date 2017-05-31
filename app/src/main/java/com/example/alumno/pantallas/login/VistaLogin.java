package com.example.alumno.pantallas.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alumno.pantallas.menu.Menu;
import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.registro.Registro;

/**
 * Created by sepagano on 30/5/2017.
 */

public class VistaLogin {

    EditText editTextMail;
    EditText editTextClave;
    Button btnIngresar;
    Button btnRegistrarme;
    Activity a;

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
        for(Persona pe : MainActivity.listPersonas)
        {
            if(pe.getMail().toString().equals(editTextMail.getText().toString()) && pe.getClave().toString().equals(editTextClave.getText().toString()))
          {

              Log.d("Exito", "Logiado");
                Context con = v.getContext();
                Intent i = new Intent(con, Menu.class);
                con.startActivity(i);

          }

        }

    }


    public void registrar(View v) {
        Context con = v.getContext();
        Intent i = new Intent(con, Registro.class);
        con.startActivity(i);

    }
}
