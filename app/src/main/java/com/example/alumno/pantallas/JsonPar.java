package com.example.alumno.pantallas;

import android.util.Log;

import com.example.alumno.pantallas.pojo.Persona;
import com.example.alumno.pantallas.pojo.Producto;

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

            JSONArray usuarios = new JSONArray(str);


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

    public List<Producto> parsearProductos(String str){
        List<Producto> lista = new ArrayList<>();
        try {
            JSONArray productos = new JSONArray(str);

            for(int i = 0; i<productos.length();i++) {
                JSONObject jsonObject = productos.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String tipoMenu = jsonObject.getString("tipoMenu");
                double precio = jsonObject.getDouble("precio");
                String imagen = jsonObject.getString("imagen");
                Log.d("tipoMenu",tipoMenu);

                lista.add(new Producto(nombre,tipoMenu,precio,imagen));

            }


        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
        }
        return lista;

    }
}
