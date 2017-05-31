package com.example.alumno.pantallas.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static   List<Persona> listPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        listPersonas = new ArrayList<>();
        listPersonas.add(new Persona("seba","pagano",40253335,"seba@hotmail.com","123123"));
        VistaLogin vista = new VistaLogin(this);
        ControladorLogin controladorLogin = new ControladorLogin(new MyListener(vista));

      /*  List<Persona> lista = new ArrayList<>();
        EditText tvMail =(EditText) findViewById(R.id.EditMailLogin);
        tvMail.setText("sebas@live.com.ar");

        EditText editClave =(EditText) findViewById(R.id.editClave);
        editClave.setText("asdasd");

        String clave = editClave.getText().toString();
        String mail = tvMail.getText().toString();

        Persona persona = new Persona("sebita@live.com.ar" , clave);
      Persona persona2 = new Persona(mail , clave);
            lista.add(persona2);
      MyListener listener = new MyListener(this,lista,persona2);
        */


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
