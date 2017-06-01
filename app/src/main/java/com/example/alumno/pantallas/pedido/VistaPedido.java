package com.example.alumno.pantallas.pedido;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.example.alumno.pantallas.MiDialogo;
import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;

/**
 * Created by sepagano on 31/5/2017.
 */

public class VistaPedido {

    private Button btnAceptarPedido;
    private Activity a;
    public VistaPedido(Activity a)
    {
        this.a = a;
        btnAceptarPedido = (Button) a.findViewById(R.id.AceptarPedido2);
        View.OnClickListener listener = new MyListener(this);
        btnAceptarPedido.setOnClickListener(listener);
    }

    public void MostrarMensaje()
    {
        MiDialogo di = new MiDialogo();
        di.show(a.getFragmentManager(),"asd");
    }

}
