package com.example.alumno.pantallas.login;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.alumno.pantallas.otros.ThreadConexion;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.List;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ModeloLogin implements  Handler.Callback {


    private VistaLogin vistaLogin;
    private int contador;
    public ModeloLogin()
    {
        contador = 0;
        Handler handler = new Handler(this);
        ThreadConexion s1 = new ThreadConexion("http://192.168.0.7:3000/usuarios",handler,2);
        Thread t = new Thread(s1);
        //http://www.mocky.io/v2/5947c614110000a10a117477 --lista usuarios por si desea optimizar tiempo

        ThreadConexion s2 = new ThreadConexion("http://192.168.0.7:3000/productos",handler,3);
        Thread t2 = new Thread(s2);
        //http://www.mocky.io/v2/5947d7d11100004e0c117504 --lista productos por si desea optimizar tiempo

        t.start();
        t2.start();


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
    public void almacenarDatos(Activity a,String mail, String clave)
    {
        SharedPreferences prefs = a.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("correo", mail);
        editor.putString("clave", clave);
        editor.putBoolean("recordarme",false );
        if(vistaLogin.getValidaCheckbox())
        {
            editor.putBoolean("recordarme",true );
        }
        editor.commit();
    }

    public void setVistaLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }
    @Override
    public boolean handleMessage(Message msg) {

        Log.d("Respuesta","Llego la respuesta del hilo");
        //  ImageView img =(ImageView) findViewById(R.id.imagenPrueba);
        // TextView txt = (TextView) findViewById(R.id.textView);
        switch (msg.arg1){
            case 0:
                Log.d("Ya estan cargados ","Cargados");
                break;
            case 1:
                Log.d("Activity","Recibiendo bytes");
                byte[] bytes = (byte[]) msg.obj;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                Listados.listaProductos.get(contador).setBitmap(bitmap);
                contador++;
                Log.d("contador",""+contador);

                //     img.setImageBitmap(bitmap);
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
                    int i = 0;

                    Handler handler1 = new Handler(this);
                    for (Producto pr : Listados.listaProductos) {
                        Log.d("Producto", pr.getNombre() + "-" + pr.getTipoMenu() + "-" + pr.getPrecio() + "-" + pr.getImagen());
                        ThreadConexion s = new ThreadConexion(Listados.listaProductos.get(i).getImagen(), handler1, 1);
                        Thread t = new Thread(s);
                        t.start();
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d("Nombre producto",pr.getNombre());
                        i++;
                    }
                }
                break;
        }

        return false;
    }

}
