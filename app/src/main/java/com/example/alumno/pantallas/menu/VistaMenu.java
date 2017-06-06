package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pedido.Pedidos;

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
    }
    public void setControladorMenu(ControladorMenu controlador)
    {
        this.controladorMenu = controlador;
    }

}
