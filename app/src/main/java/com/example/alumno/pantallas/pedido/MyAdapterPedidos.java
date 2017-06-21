package com.example.alumno.pantallas.pedido;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.pedido.MyViewHolderPedidos;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.List;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyAdapterPedidos extends RecyclerView.Adapter<MyViewHolderPedidos>{


    List<Producto> listaProductos;
    private Button btn;
    private Activity a;

    public MyAdapterPedidos(List<Producto> lista, Activity a)

    {
        this.listaProductos = lista;
        this.a = a;



    }
    @Override
    public MyViewHolderPedidos onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itempedidos_layout,parent,false);
        MyViewHolderPedidos mv = new MyViewHolderPedidos(v,this,a);
        return mv;

    }

    @Override
    public void onBindViewHolder(MyViewHolderPedidos holder, int position) {
        Producto p = listaProductos.get(position);
        holder.tvNombre.setText(p.getNombre());
        holder.tvPrecio.setText(""+p.getPrecio()+"$");
        holder.ivImagen.setImageBitmap(p.getBitmap());
        holder.btnQuitar.setOnClickListener((View.OnClickListener)holder );
        holder.setPositionYProducto(position,p);


    }

    @Override
    public int getItemCount() {
        return this.listaProductos.size();
    }


}
