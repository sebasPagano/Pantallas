package com.example.alumno.pantallas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{


    List<Pedido> ListaPedidos;

    public MyAdapter(List<Pedido> lista)
    {
        this.ListaPedidos = lista;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MyViewHolder mv = new MyViewHolder(v);
        return mv;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pedido p = ListaPedidos.get(position);
        holder.tvNombre.setText(p.getNombre());
        holder.tvPrecio.setText(""+p.getPrecio()+"$");

    }

    @Override
    public int getItemCount() {
        return this.ListaPedidos.size();
    }
}
