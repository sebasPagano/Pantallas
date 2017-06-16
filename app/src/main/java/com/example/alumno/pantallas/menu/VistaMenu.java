package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumno.pantallas.ListenerAlert;
import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pedido.Pedidos;
import com.example.alumno.pantallas.pojo.Listados;

/**
 * Created by sepagano on 31/5/2017.
 */

public class VistaMenu {

    private Button btn;
    private TextView cantidadSeleccionada;
    private TextView precioTotal;
    private ControladorMenu controladorMenu;
    private Activity a;
    public VistaMenu(Activity a)
    {
        this.a  = a;
        btn = (Button) this.a.findViewById(R.id.btnEnviarPedido);
        cantidadSeleccionada = (TextView) this.a.findViewById(R.id.cantidad);
        precioTotal =(TextView) this.a.findViewById(R.id.sumaPrecio);
        View.OnClickListener listener = new MyListener(this);
        btn.setOnClickListener(listener);
    }
    public void enviandoPedido(View v)
    {

        controladorMenu.irAPedido(v);
        if(Listados.listaProductoDelPedido.size() == 0) {

            AlertDialog.Builder builder = new AlertDialog.Builder(a);
            builder.setTitle("No puede enviar 0 productos!");
            builder.setMessage("No tiene productos seleccionados");
            ListenerAlert l = new ListenerAlert();
            builder.setPositiveButton("OK", l);
            AlertDialog ad = builder.create();
            ad.show();
        }
    }
    public void setControladorMenu(ControladorMenu controlador)
    {
        this.controladorMenu = controlador;
    }

}
