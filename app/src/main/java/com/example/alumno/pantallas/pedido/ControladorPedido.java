package com.example.alumno.pantallas.pedido;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.otros.ListenerAlert;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.menu.Menu;
import com.example.alumno.pantallas.pojo.Listados;

/**
 * Created by sepagano on 31/5/2017.
 */

public class ControladorPedido {

    private ModeloPedido modeloPedido;
    private VistaPedido vistaPedido;
    private Activity a;



    public ControladorPedido(VistaPedido vistaPedido, ModeloPedido modeloPedido, Activity a) {
        this.vistaPedido = vistaPedido;
        this.modeloPedido = modeloPedido;
        this.a = a;

    }

    public void irAMenu() {
        if (Listados.listaProductoDelPedido.size() != 0) {
            this.MostrarMensaje();
        } else {
            this.MostrarMensajeError();
        }

    }

    public void MostrarMensaje() {
        String precio = a.getString(R.string.precio);
        String cantidad = a.getString(R.string.productos);
        String enviado = a.getString(R.string.enviado);
        String aceptar = a.getString(R.string.aceptar);


        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle(enviado + "!!!");

        builder.setMessage(cantidad + vistaPedido.productosTotal.getText() + "\n\n" + precio + vistaPedido.precioTotal.getText());
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Context con = vistaPedido.v.getContext();
                        Intent i = new Intent(con, Menu.class);
                        con.startActivity(i);
                    }
                });
        AlertDialog ad = builder.create();
        ad.show();

    }

    public void MostrarMensajeError() {

        String alerta = a.getString(R.string.alerta);
        String aceptar = a.getString(R.string.aceptar);
        String mensajeError = a.getString(R.string.mensajeError);

        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle(alerta + "!!!");
        builder.setMessage(mensajeError);
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Context con = vistaPedido.v.getContext();
                        Intent i = new Intent(con, Menu.class);
                        con.startActivity(i);
                    }
                });
        AlertDialog ad = builder.create();
        ad.show();
    }

    public void logOut() {
        SharedPreferences prefs = a.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();

        Context con = vistaPedido.v.getContext();
        Intent i = new Intent(con, MainActivity.class);
        con.startActivity(i);
    }


    public void setVistaPedido(VistaPedido vistaPedido) {
        this.vistaPedido = vistaPedido;
    }

    public void setModeloPedido(ModeloPedido modeloPedido) {
        this.modeloPedido = modeloPedido;
    }

}
