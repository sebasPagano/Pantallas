package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pedido.Pedidos;

/**
 * Created by sepagano on 31/5/2017.
 */

public class VistaMenu {

    private Button btn;
    private Activity a;
    public VistaMenu(Activity a)
    {
        this.a  = a;
        Button btn = (Button) this.a.findViewById(R.id.btnEnviarPedido);
        View.OnClickListener listener = new MyListener(this);
        btn.setOnClickListener(listener);
    }
    public void irApedido(View v)
    {
        Context con = v.getContext();
        Intent i = new Intent(con, Pedidos.class);
        con.startActivity(i);

    }

}
