package com.example.alumno.pantallas.pedido;

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
    Button btnQuitar;
    Producto producto;
    MyAdapterPedidos adapter;
    private static List<Producto> listaProducto = Listados.getListaProductos();




    private int position;

    public MyViewHolderPedidos(View itemView, MyAdapterPedidos adapter)
    {

        super(itemView);
        tvNombre = (TextView) itemView.findViewById(R.id.tvNombrePedido);
        tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecioPedido);
        ivImagen = (ImageView) itemView.findViewById(R.id.IVimagenPedido);
        btnQuitar = (Button) itemView.findViewById(R.id.btnQuitarProducto);
        this.adapter = adapter;
    }




    @Override
    public void onClick(View v) {
        //  listener.onItemClick(position);
        for (Producto producto: this.listaProducto)
        {
            Log.d("Productos",producto.getNombre());
        }
        if(v.getId() == R.id.btnQuitarProducto)
        {
            Log.d("Hizo click en el producto",this.position+" - "+this.producto.getNombre());
            listaProducto.remove(this.getLayoutPosition());
            adapter.notifyDataSetChanged();
        }






    }
    public static List<Producto> getlista()
    {
        return listaProducto;
    }
    public static void setlista(List<Producto> lista )
    {
        listaProducto = lista;
    }





    public void setPositionYProducto(int position,Producto producto)
    {
        this.position = position;
        this.producto = producto;
    }

}
