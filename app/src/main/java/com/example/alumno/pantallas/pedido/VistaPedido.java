package com.example.alumno.pantallas.pedido;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumno.pantallas.otros.ListenerAlert;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

/**
 * Created by sepagano on 31/5/2017.
 */

public class VistaPedido {

    private Button btnAceptarPedido;
    private ControladorPedido controladorPedido;
    public TextView precioTotal;
    public TextView productosTotal;
    private Activity a;
    public View v;
    public VistaPedido(Activity a)
    {
        this.a = a;
        this.v = a.getLayoutInflater().inflate(R.layout.activity_pedido, null);
        btnAceptarPedido = (Button) a.findViewById(R.id.AceptarPedido2);
        precioTotal =(TextView) this.a.findViewById(R.id.sumaPrecio2);
        productosTotal = (TextView) this.a.findViewById(R.id.cantidad2);
        View.OnClickListener listener = new MyListener(this);

        double suma = 0;

        for (Producto prod: Listados.listaProductoDelPedido)
        {
            suma = suma + prod.getPrecio();
        }
        productosTotal.setText(String.valueOf(Listados.listaProductoDelPedido.size()));
        precioTotal.setText(String.valueOf(suma)+"$");
        btnAceptarPedido.setOnClickListener(listener);
    }

    public void enviarPedido()
    {
        controladorPedido.irAMenu();
    }

    public void setControladorPedido(ControladorPedido controlador)
    {
        this.controladorPedido = controlador;
    }

}
