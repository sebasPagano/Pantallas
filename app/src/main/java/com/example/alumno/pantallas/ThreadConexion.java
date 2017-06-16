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
            msg.obj=   conexion.getBytesDateByGET(this.url);
            msg.arg1 = 1;
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
