package com.example.alumno.pantallas;

import android.util.Log;

import com.example.alumno.pantallas.pojo.Persona;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sepagano on 15/6/2017.
 */

public class JsonPar {

    public List<Persona> parsear(String str){
        List<Persona> lista = new ArrayList<>();
        try {
            //  JSONObject jsonObject = new JSONObject(str);
            //JSONArray frutas = jsonObject.getJSONArray("usuarios");
            JSONArray usuarios = new JSONArray(str);

            //   for(int i = 0; i<frutas.length();i++)
            // {
            //JSONObject fruta = frutas.getJSONObject(i);
             /*   String mensaje = jsonObject.getString("mensaje");
                Integer cod = jsonObject.getInt("codigo");
*/

            //JSONArray usuarios = jsonObject.getJSONArray("usuarios");

            for(int i = 0; i<usuarios.length();i++) {
                JSONObject jsonObject = usuarios.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String clave = jsonObject.getString("clave");
                String mail = jsonObject.getString("mail");
                long dni = jsonObject.getInt("dni");

                lista.add(new Persona(nombre,apellido,dni,mail,clave));


            }


        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
        }
        return lista;
    }
}
