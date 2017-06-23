package com.example.alumno.pantallas.menu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.menu.MyViewHolder;
import com.example.alumno.pantallas.otros.ThreadConexion;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.List;

/**
 * Created by Pagano on 01/05/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements  Handler.Callback{


    List<Producto> listaProductos;
    private Activity a;
    private Handler handler;
    private Producto p;

    public MyAdapter(List<Producto> lista, Activity a)
    {
        this.listaProductos = lista;
        this.a = a;
        this.handler = new Handler(this);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MyViewHolder mv = new MyViewHolder(v,a);
        mv.btnAgregar.setOnClickListener(mv );
        return mv;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        p = listaProductos.get(position);
        holder.tvNombre.setText(p.getNombre());
        holder.tvPrecio.setText(""+p.getPrecio()+"$");


        if(p.getBitmap() == null)
        {
            ThreadConexion threadConexion = new ThreadConexion(p.getImagen(),handler,1);
            threadConexion.setPosicion(position);
            Thread t = new Thread(threadConexion);
            t.start();

        }else
        {
            holder.ivImagen.setImageBitmap(p.getBitmap());
        }

        holder.setPositionYProducto(position,p);



    }

    @Override
    public int getItemCount() {
        return this.listaProductos.size();
    }

    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.arg1) {
            case 0:
                Log.d("Ya estan cargados ", "Cargados");
                break;
            case 1:
                Log.d("Activity", "Recibiendo bytes");
                byte[] bytes = (byte[]) msg.obj;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                listaProductos.get(msg.arg2).setBitmap(bitmap);
                this.notifyDataSetChanged();
                break;
        }
        return false;
    }
}
