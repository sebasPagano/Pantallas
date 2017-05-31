package com.example.alumno.pantallas.menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.menu.MyViewHolder;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.List;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{


    List<Producto> listaProductos;
    private Button btn;


    public MyAdapter(List<Producto> lista)

    {
        this.listaProductos = lista;



    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MyViewHolder mv = new MyViewHolder(v);
        return mv;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Producto p = listaProductos.get(position);
        holder.tvNombre.setText(p.getNombre());
        holder.tvPrecio.setText(""+p.getPrecio()+"$");
        holder.ivImagen.setImageResource(p.getRuta());
        holder.btnAgregar.setOnClickListener((View.OnClickListener)holder );
        holder.setPositionYProducto(position,p);

    }

    @Override
    public int getItemCount() {
        return this.listaProductos.size();
    }
}
