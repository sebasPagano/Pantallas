package com.example.alumno.pantallas.pedido;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.alumno.pantallas.ListenerAlert;
import com.example.alumno.pantallas.MiDialogo;
import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.menu.ControladorMenu;
import com.example.alumno.pantallas.pojo.Listados;

/**
 * Created by sepagano on 31/5/2017.
 */

public class VistaPedido {

    private Button btnAceptarPedido;
    private ControladorPedido controladorPedido;
    private Activity a;
    private View v;
    public VistaPedido(Activity a)
    {
        this.a = a;
        btnAceptarPedido = (Button) a.findViewById(R.id.AceptarPedido2);
        View.OnClickListener listener = new MyListener(this);
        this.v = a.getLayoutInflater().inflate(R.layout.activity_pedido, null);
        btnAceptarPedido.setOnClickListener(listener);
    }

    public void MostrarMensaje()
    {
        /*
        MiDialogo di = new MiDialogo();
        di.show(a.getFragmentManager(),"asd")*/
        controladorPedido.setView(v);
        if(Listados.listaProductoDelPedido.size() != 0) {

            AlertDialog.Builder builder = new AlertDialog.Builder(a);
            builder.setTitle("Enviado!");
            builder.setMessage("Aceptado pedido");
            ListenerAlert l = new ListenerAlert();
            builder.setPositiveButton(("OK"),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            controladorPedido.irAMenu();
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        }
        else
        {
            this.MostrarMensajeError();
        }

        //

    }

    public void MostrarMensajeError()
    {
        controladorPedido.setView(v);
        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle("No puede enviar 0 productos!");
        builder.setMessage("No tiene elementos");
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(("OK"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        controladorPedido.irAMenu();
                    }
                });
        AlertDialog ad = builder.create();
        ad.show();


        //

    }



    public void setControladorPedido(ControladorPedido controlador)
    {
        this.controladorPedido = controlador;
    }

}
