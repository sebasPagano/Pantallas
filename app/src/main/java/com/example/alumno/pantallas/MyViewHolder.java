package com.example.alumno.pantallas;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView tvNombre;
    TextView tvPrecio;
    ImageView ivImagen;
    Button btnAgregar;
    Producto producto;
    private static List<Producto>  listaProducto = new ArrayList<>();




    private int position;

    public MyViewHolder(View itemView)
    {

        super(itemView);
        tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
        tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        ivImagen = (ImageView) itemView.findViewById(R.id.IVimagen);
        btnAgregar = (Button) itemView.findViewById(R.id.btnAgregarProducto);


    }




    @Override
    public void onClick(View v) {

        Log.d("Hizo click en la vista","ASD");
        double suma = 0;
        if(v.getId() == R.id.btnAgregarProducto)
        {

            Log.d("Hizo click en el producto",this.producto.getNombre());
            listaProducto.add(this.producto);

        }
        for (Producto prod: listaProducto)
        {
            suma = suma + prod.getPrecio();
        }
        Log.d("Suma",""+suma);




    }
    public static List<Producto> getlista()
    {
        return listaProducto;
    }


    public static int getcantidadlista()
    {
        return listaProducto.size();
    }

    public void setPositionYProducto(int position,Producto producto)
    {
        this.position = position;
        this.producto = producto;
    }

}
