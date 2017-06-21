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
    private TextView precioTotal;
    private TextView productosTotal;
    private Activity a;
    private View v;
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

        if(Listados.listaProductoDelPedido.size() != 0) {

           this.MostrarMensaje();
        }
        else
        {
            this.MostrarMensajeError();
        }



    }

    public void MostrarMensaje()
    {
        String precio = a.getString(R.string.precio);
        String cantidad = a.getString(R.string.productos);
        String enviado = a.getString(R.string.enviado);
        String aceptar = a.getString(R.string.aceptar);

        controladorPedido.setView(v);
        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle(enviado+"!!!");

        builder.setMessage(cantidad+productosTotal.getText()+"\n\n"+precio+precioTotal.getText());
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        controladorPedido.irAMenu();
                    }
                });
        AlertDialog ad = builder.create();
        ad.show();

    }
    public void MostrarMensajeError()
    {

        String alerta = a.getString(R.string.alerta);
        String aceptar = a.getString(R.string.aceptar);
        String mensajeError = a.getString(R.string.mensajeError);

        controladorPedido.setView(v);
        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle(alerta+"!!!");
        builder.setMessage(mensajeError);
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        controladorPedido.irAMenu();
                    }
                });
        AlertDialog ad = builder.create();
        ad.show();
    }

    public void setControladorPedido(ControladorPedido controlador)
    {
        this.controladorPedido = controlador;
    }

}
