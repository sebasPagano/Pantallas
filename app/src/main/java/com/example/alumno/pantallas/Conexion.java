package com.example.alumno.pantallas;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alumno on 11/05/2017.
 */

public class Conexion {

    public byte[] getBytesDateByGET(String strUrl) throws IOException{
// es sincronico
        URL url = new URL(strUrl);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        int response = urlConnection.getResponseCode();

        Log.d("http", "Response code:"+response);

        if(response == 200)
        {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int lenght = 0;
            while((lenght = is.read(buffer)) != -1)
            {
                baos.write(buffer,0,lenght);
            }
            is.close();
            return baos.toByteArray();

        }else{
            throw new IOException();
        }

    }

    public String getBytesDateByGET2(String strUrl) throws IOException{
// es sincronico
        URL url = new URL(strUrl);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        int response = urlConnection.getResponseCode();

        Log.d("http", "Response code:"+response);

        if(response == 200)
        {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int lenght = 0;
            while((lenght = is.read(buffer)) != -1)
            {
                baos.write(buffer,0,lenght);
            }
            is.close();
            return new String(baos.toByteArray());

        }else{
            throw new IOException();
        }



    }

}
