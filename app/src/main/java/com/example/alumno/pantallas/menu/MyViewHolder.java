package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public TextView tvNombre;
    public TextView tvPrecio;
    public ImageView ivImagen;
    public FloatingActionButton btnAgregar;
    private Producto producto;
    private int position;
    private TextView cantidad;
    private TextView precioTotal;


    public MyViewHolder(View itemView, Activity a)
    {

        super(itemView);
        tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
        tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        ivImagen = (ImageView) itemView.findViewById(R.id.IVimagen);
        btnAgregar = (FloatingActionButton ) itemView.findViewById(R.id.btnAgregarProducto);
        cantidad = (TextView) a.findViewById(R.id.cantidad);
        precioTotal =(TextView) a.findViewById(R.id.sumaPrecio);

    }



    @Override
    public void onClick(View v) {

        double suma = 0;
        if(v.getId() == R.id.btnAgregarProducto)
        {

            Log.d("Hizo click en el producto",this.producto.getNombre());
            Listados.listaProductoDelPedido.add(this.producto);
            cantidad.setText(String.valueOf(Listados.listaProductoDelPedido.size()));

            for (Producto prod: Listados.listaProductoDelPedido)
            {
                suma = suma + prod.getPrecio();
            }
            precioTotal.setText(String.valueOf(suma)+"$");

        }

        Log.d("Suma",""+suma);

    }


    public void setPositionYProducto(int position,Producto producto)
    {
        this.position = position;
        this.producto = producto;
    }

}
