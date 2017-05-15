package com.example.alumno.pantallas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tvNombre;
    TextView tvPrecio;
    ImageView ivImagen;


    public MyViewHolder(View itemView)
    {

        super(itemView);
        tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
        tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        ivImagen = (ImageView) itemView.findViewById(R.id.IVimagen);
    }

}
