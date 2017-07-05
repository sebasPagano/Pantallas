package com.example.alumno.pantallas.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.otros.ListenerAlert;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.menu.Menu;
import com.example.alumno.pantallas.otros.ThreadConexion;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.pojo.Producto;
import com.example.alumno.pantallas.registro.Registro;

import java.util.List;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorLogin implements Handler.Callback {


    private  ModeloLogin modeloLogin;
    private boolean tieneAcceso;
    private Activity a;
    private VistaLogin vistaLogin;


    public ControladorLogin(VistaLogin vistaLogin, ModeloLogin modeloLogin,Activity a)
    {
        this.vistaLogin = vistaLogin;
        this.modeloLogin = modeloLogin;
        this.a = a;
        this.recordarme();
        Handler handler = new Handler(this);
        ThreadConexion s1 = new ThreadConexion("http://www.mocky.io/v2/5947c614110000a10a117477",handler,2);
        Thread t = new Thread(s1);
        //http://www.mocky.io/v2/5947c614110000a10a117477 --lista usuarios por si desea optimizar tiempo

        ThreadConexion s2 = new ThreadConexion("http://www.mocky.io/v2/5947d7d11100004e0c117504",handler,3);
        Thread t2 = new Thread(s2);
        //http://www.mocky.io/v2/5947d7d11100004e0c117504 --lista productos por si desea optimizar tiempo

        t.start();
        t2.start();

    }

    public void irRegistrar(View v) {
        Context con = v.getContext();
        Intent i = new Intent(con, Registro.class);
        con.startActivity(i);
    }

    public void irMenu(View v, String mail,String clave){
      tieneAcceso = this.encontrarUsuario(mail,clave);

        if(tieneAcceso) {

            this.almacenarDatos(a,mail,clave);

            Context con = v.getContext();
            Intent i = new Intent(con, Menu.class);
            con.startActivity(i);

        }else
        {
            this.MostrarMensajeError();

        }
    }

    public void almacenarDatos(Activity a,String mail, String clave)
    {
        SharedPreferences prefs = a.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("correo", mail);
        editor.putString("clave", clave);
        editor.putBoolean("recordarme",false );
        if(vistaLogin.checkBox.isChecked())
        {
            editor.putBoolean("recordarme",true );
        }
        editor.commit();
    }


    public boolean encontrarUsuario(String mail, String clave)
    {
        for(Persona pe : Listados.listaPersonas)
        {
            Log.d("Persona",pe.toString());

            if(pe.getMail().toString().equals(mail) && pe.getClave().toString().equals(clave))
            {
                return true;
            }

        }

        return false;
    }
    public void recordarme()
    {
        SharedPreferences prefs = a.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        boolean datoStr = prefs.getBoolean("recordarme",false);

        if(datoStr==true) {
            View v = a.getLayoutInflater().inflate(R.layout.activity_menu, null);

            Context con = v.getContext();
            Intent i = new Intent(con, Menu.class);
            con.startActivity(i);

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


    public boolean isTieneAcceso() {
        return tieneAcceso;
    }

    public void setActivity(Activity a) {
        this.a = a;
    }

    @Override
    public boolean handleMessage(Message msg) {

        Log.d("Respuesta","Llego la respuesta del hilo");
        switch (msg.arg1){
            case 0:
                Log.d("Ya estan cargados ","Cargados");
                break;
            case 1:
                Log.d("Activity","Recibiendo bytes");
                byte[] bytes = (byte[]) msg.obj;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                break;

            case 2:
                if(Listados.listaPersonas.size() == 1 || Listados.listaPersonas.size() == 0) {
                    List<Persona> personas = (List<Persona>) msg.obj;

                    for (Persona p : personas) {
                        Log.d("Persona", p.getNombre() + "-" + p.getApellido() + "-" + p.getMail() + "-" + p.getClave() + "-" + p.getDni());
                        Listados.listaPersonas.add(p);
                    }

                }
                break;

            case 3:
                if(Listados.listaProductos.size() == 0) {
                    List<Producto> productos = (List<Producto>) msg.obj;

                    for (Producto pr : productos) {
                        Log.d("Producto", pr.getNombre());
                        Listados.listaProductos.add(pr);

                    }

                }
                break;
        }

        return false;
    }

}
