package com.example.alumno.pantallas.otros;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.alumno.pantallas.otros.Conexion;
import com.example.alumno.pantallas.otros.JsonPar;
import com.example.alumno.pantallas.pojo.Listados;

/**
 * Created by alumno on 11/05/2017.
 */

public class ThreadConexion implements Runnable {


    private String url;
    private Handler handler;
    private int opcion;

    public ThreadConexion()
    {

    }
    public ThreadConexion(String url, Handler handler,int opcion)
    {
        this.url = url;
        this.handler = handler;
        this.opcion = opcion;

    }

    @Override
    public void run() {

        Message msg = new Message();

        Conexion conexion = new Conexion();
        JsonPar jsonPar = new JsonPar();
        String strRespuesta;
        try {
            // byte[] arrayByte;
            switch (opcion) {
                case 1:
                    synchronized (this) {
                        msg.obj = conexion.getBytesDateByGETImagen(this.url);
                        msg.arg1 = 1;
                    }
                break;

                case 2:
                    if(Listados.listaPersonas.size()==0 || Listados.listaPersonas.size()==1) {
                        Log.d("Que pasa", "llamando a getbytes");
                        strRespuesta = conexion.getBytesDateByGETString(this.url);
                        Log.d("Que pasa", strRespuesta);

                        msg.arg1 = 2;

                        msg.obj = jsonPar.parsearUsuarios(strRespuesta);
                    }
                    break;
                case 3:
                    if(Listados.listaProductos.size() == 0) {
                        strRespuesta = conexion.getBytesDateByGETString(this.url);
                        Log.d("Que pasa", strRespuesta);
                        msg.arg1 = 3;
                        msg.obj = jsonPar.parsearProductos(strRespuesta);
                    }
                    break;


            }
        }catch (Exception e)
        {
            Log.d("Error","mal ahi");
        }
        handler.sendMessage(msg);


    }

    public String getUrl(String url)
    {
        return url;
    }


}
