package com.example.alumno.pantallas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pagano on 03/05/2017.
 */

public class MyListener implements View.OnClickListener {

    Activity a;
    List<Persona> listaPersonas;
    Persona personaIngresante;

    public MyListener(Activity ac,List<Persona> lista, Persona per)
    {
        this.a = ac;
        this.listaPersonas = lista;
        this.personaIngresante = per;
    }



    @Override
    public void onClick(View v) {

        MainActivity m = new MainActivity();
        if(v.getId() == R.id.btnRegistro) {
            Context con = v.getContext();
            Intent i = new Intent(con, Registro.class);
            con.startActivity(i);
        }

        for(Persona persona : listaPersonas)
        {
            if(persona.getMail().equals(this.personaIngresante.getMail()))
            {
                if(v.getId() == R.id.btnIngresar) {
                    Log.d("Permitido Acceso","Encontrado");
                    Context con = v.getContext();
                    Intent i = new Intent(con, Menu.class);
                    con.startActivity(i);
                }
            }else
            {
                Log.d("Acceso denegado","No Encontrado");
            }

        }

    }

    public List<Persona> retornarLista(List<Persona> lista)
    {
        return lista;
    }
}
