package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumno.pantallas.otros.ListenerAlert;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.R;
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
    public View v;
    public VistaMenu(Activity a)
    {
        this.a  = a;
        this.v = a.getLayoutInflater().inflate(R.layout.activity_pedido, null);
        btn = (Button) this.a.findViewById(R.id.btnEnviarPedido);
        cantidadSeleccionada = (TextView) this.a.findViewById(R.id.cantidad);
        precioTotal =(TextView) this.a.findViewById(R.id.sumaPrecio);
        View.OnClickListener listener = new MyListener(this);
        btn.setOnClickListener(listener);
    }
    public void enviandoPedido()
    {
        controladorMenu.irAPedido();
    }
    public void setControladorMenu(ControladorMenu controlador)
    {
        this.controladorMenu = controlador;
    }

}
