package com.example.alumno.pantallas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        List<Persona> lista = new ArrayList<>();
        EditText tvMail =(EditText) findViewById(R.id.EditMailLogin);
        tvMail.setText("sebas@live.com.ar");

        EditText editClave =(EditText) findViewById(R.id.editClave);
        editClave.setText("asdasd");

        String clave = editClave.getText().toString();
        String mail = tvMail.getText().toString();

        Persona persona = new Persona("sebita@live.com.ar" , clave);
        Persona persona2 = new Persona(mail , clave);
        lista.add(persona);

        Button btn = (Button) findViewById(R.id.btnRegistro);
        Button btn2 = (Button) findViewById(R.id.btnIngresar);
        MyListener listener = new MyListener(this,lista,persona2);
       btn.setOnClickListener((View.OnClickListener) listener);
        btn2.setOnClickListener((View.OnClickListener) listener);


    }


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nuevo_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.opcion1) {
            Log.d("click", "opcion del menu");
            return super.onOptionsItemSelected(item);
        }
        return false;

    }*/
}
