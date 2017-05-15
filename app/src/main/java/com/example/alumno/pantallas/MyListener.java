package com.example.alumno.pantallas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Pagano on 03/05/2017.
 */

public class MyListener implements View.OnClickListener {

    Activity a;

    public MyListener(Activity ac)
    {
        this.a = ac;
    }



    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnRegistro) {
            Context con = v.getContext();
            Intent i = new Intent(con, Registro.class);
            con.startActivity(i);
        }
    }
}
