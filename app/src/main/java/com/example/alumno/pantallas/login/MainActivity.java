package com.example.alumno.pantallas.login;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumno.pantallas.JsonPar;
import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.ThreadConexion;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pojo.Producto;
import com.example.alumno.pantallas.registro.ControladorRegistro;
import com.example.alumno.pantallas.registro.ModeloRegistro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements  Handler.Callback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Listados listados = Listados.getListados();
        Listados.listaProductoDelPedido.clear();
        ModeloLogin modeloLogin = new ModeloLogin();
        VistaLogin vista = new VistaLogin(this);
        ControladorLogin controladorLogin = new ControladorLogin(new MyListener(vista));
        controladorLogin.setModeloLogin(modeloLogin);
        vista.setControladorLogin(controladorLogin);



       Handler handler = new Handler(this);

        ThreadConexion s1 = new ThreadConexion("http://www.mocky.io/v2/5947c614110000a10a117477",handler,2);
        Thread t = new Thread(s1);
        ThreadConexion s2 = new ThreadConexion("http://www.mocky.io/v2/5947d7d11100004e0c117504",handler,3);
        Thread t2 = new Thread(s2);

        t.start();
        t2.start();


    }

    @Override
    public boolean handleMessage(Message msg) {

        Log.d("Respuesta","Llego la respuesta del hilo");
      //  ImageView img =(ImageView) findViewById(R.id.imagenPrueba);
       // TextView txt = (TextView) findViewById(R.id.textView);
        switch (msg.arg1){
            case 0:
                Log.d("Activity ","Error");
                break;
            case 1:
                Log.d("Activity","Recibiendo bytes");
                byte[] bytes = (byte[]) msg.obj;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
           //     img.setImageBitmap(bitmap);
                break;
            case 2:
                List<Persona> personas = (List<Persona>) msg.obj;

                for(Persona p : personas) {
                    Log.d("Persona",p.getNombre()+"-"+p.getApellido()+"-"+p.getMail()+"-"+p.getClave()+"-"+p.getDni());
                    Listados.listaPersonas.add(p);
                }

                for(Persona p : Listados.listaPersonas) {
                    Log.d("Personass en listapersonas",p.getNombre()+"-"+p.getApellido()+"-"+p.getMail()+"-"+p.getClave()+"-"+p.getDni());
                    ;
                }

                break;

            case 3:
                List<Producto> productos = (List<Producto>) msg.obj;

                for(Producto pr : productos) {
                    Log.d("Producto",pr.getNombre());
                    Listados.listaProductos.add(pr);

                }
                for(Producto pr : Listados.listaProductos) {
                    Log.d("Producto",pr.getNombre()+"-"+pr.getTipoMenu()+"-"+pr.getPrecio2()+"-"+pr.getImagen());

                }
                //     Persona p =(Persona) msg.obj;
              //  Producto pr = productos.get(0);
                //   String nombre = (String)msg.obj;




                break;
        }

        return false;
    }
}
