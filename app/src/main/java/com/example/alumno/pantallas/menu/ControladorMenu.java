package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.otros.ListenerAlert;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.pedido.Pedidos;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ControladorMenu {

    private ModeloMenu modeloMenu;
    private VistaMenu vistaMenu;
    private Activity a;
    private List<Producto> lista;


    public ControladorMenu(VistaMenu vistaMenu, ModeloMenu modeloMenu,Activity a)
    {
        this.vistaMenu = vistaMenu;
        this.modeloMenu = modeloMenu;
        this.a = a;
        this.lista = new ArrayList<>();
    }



    public void setModeloMenu(ModeloMenu modelo)
    {
        this.modeloMenu = modelo;
    }

    public void irAPedido()
    {
        if(this.ListaNoEsNull() == true) {
            Context con = vistaMenu.v.getContext();
            Intent i = new Intent(con, Pedidos.class);
            con.startActivity(i);
        }else
        {
            this.MensajeError();
        }
    }
    public boolean ListaNoEsNull()
    {
        if(Listados.listaProductoDelPedido.size() > 0)
        {
            return true;
        }
        return false;

    }

    public void MensajeError()
    {
        String alerta = a.getString(R.string.alerta);
        String aceptar = a.getString(R.string.aceptar);
        String mensajeError = a.getString(R.string.mensajeError);

        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle(alerta+"!!!");
        builder.setMessage(mensajeError);
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar, l);
        AlertDialog ad = builder.create();
        ad.show();
    }
    public List<Producto> getListaPrincipal(List<Producto> listaProducto)
    {
        for(Producto p : Listados.listaProductos)
        {
            if(p.getTipoMenu().equals("Principal"))
            {
                listaProducto.add(p);
            }
        }
        return listaProducto;
    }
    public List<Producto> getListaBebidas(List<Producto> listaProducto)
    {
        for(Producto p : Listados.listaProductos)
        {
            if(p.getTipoMenu().equals("Bebida"))
            {
                listaProducto.add(p);
            }
        }
        return listaProducto;

    }
    public List<Producto> getListaSnack(List<Producto> listaProducto)
    {
        for(Producto p : Listados.listaProductos)
        {
            if(p.getTipoMenu().equals("Snack"))
            {
                listaProducto.add(p);
            }
        }
        return listaProducto;
    }
    public void volverAlLogin()
    {
        Context con = vistaMenu.v.getContext();
        Intent i = new Intent(con, MainActivity.class);
        con.startActivity(i);
    }
    public void logOut() {
        SharedPreferences prefs = a.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();

        this.volverAlLogin();
    }


}
