package com.example.alumno.pantallas;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by sepagano on 15/6/2017.
 */

public class JsonPar {

    public void parsear(String str){
        try{
            JSONObject jsonObject = new JSONObject(str);
//            JSONArray frutas = jsonObject.getJSONArray("frutas");

            //   for(int i = 0; i<frutas.length();i++)
            // {
            //JSONObject fruta = frutas.getJSONObject(i);
            String mensaje = jsonObject.getString("mensaje");
            Integer cod = jsonObject.getInt("codigo");
            Log.d("Mensaje"+mensaje,cod.toString());
            //}

        }
        catch (Exception e)
        {

        }

    }
}
