package com.example.alumno.pantallas.pedido;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.menu.MyViewHolder;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.List;
import java.util.Set;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyViewHolderPedidos extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView tvNombre;
    TextView tvPrecio;
    ImageView ivImagen;
    FloatingActionButton btnQuitar;
    private Producto producto;
    private static MyAdapterPedidos adapter;
    private static TextView precioTotal;
    private static TextView elementosSeleccionados;
    private Activity a;
    private int position;



    public MyViewHolderPedidos(View itemView, MyAdapterPedidos adapter,Activity a)
    {
        super(itemView);
        this.adapter = adapter;
        this.a = a;
        tvNombre = (TextView) itemView.findViewById(R.id.tvNombrePedido);
        tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecioPedido);
        ivImagen = (ImageView) itemView.findViewById(R.id.IVimagenPedido);
        btnQuitar = (FloatingActionButton) itemView.findViewById(R.id.btnQuitarProducto);
        precioTotal = (TextView) a.findViewById(R.id.sumaPrecio2);
        elementosSeleccionados = (TextView) a.findViewById(R.id.cantidad2);
    }



    @Override
    public void onClick(View v) {

        double suma = 0;
        if(v.getId() == R.id.btnQuitarProducto) {
            Log.d("Hizo click en el producto", this.position + " - " + this.producto.getNombre());

            Listados.listaProductoDelPedido.remove(this.getLayoutPosition());
            elementosSeleccionados.setText(String.valueOf(Listados.listaProductoDelPedido.size()));

            for (Producto prod : Listados.listaProductoDelPedido) {
                suma = suma + prod.getPrecio();
            }
            precioTotal.setText(String.valueOf(suma)+"$");

            adapter.notifyDataSetChanged();


        }
    }
    public static void limpiar()
    {
        Listados.listaProductoDelPedido.clear();
        elementosSeleccionados.setText(String.valueOf(0));

        precioTotal.setText(String.valueOf(0.0)+"$");

        adapter.notifyDataSetChanged();
    }


    public void setPositionYProducto(int position,Producto producto)
    {
        this.position = position;
        this.producto = producto;
    }

}
