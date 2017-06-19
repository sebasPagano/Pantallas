package com.example.alumno.pantallas;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by alumno on 11/05/2017.
 */

public class ThreadConexion implements Runnable {


    private String url;
    private Handler handler;

    public ThreadConexion()
    {

    }
    public ThreadConexion(String url, Handler handler)
    {
        this.url = url;
        this.handler = handler;

    }

    @Override
    public void run() {

        Message msg = new Message();

        Conexion conexion = new Conexion();

        try {
            // byte[] arrayByte;
           // msg.obj=   conexion.getBytesDateByGET(this.url);
           // msg.arg1 = 1;

            JsonPar jsonPar = new JsonPar();

            String strRespuesta;
            Log.d("Que pasa","llamando a getbytes");
            strRespuesta=   conexion.getBytesDateByGET2(this.url);
            Log.d("Que pasa",strRespuesta);

            msg.arg1 = 2;

            msg.obj =jsonPar.parsear(strRespuesta);

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
