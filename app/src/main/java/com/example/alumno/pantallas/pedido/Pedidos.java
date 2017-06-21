package com.example.alumno.pantallas.pedido;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alumno.pantallas.menu.MyViewHolder;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

public class Pedidos extends AppCompatActivity {

    private ControladorPedido controladorPedido;
    private VistaPedido vistaPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        MyAdapterPedidos adapter = new MyAdapterPedidos(Listados.listaProductoDelPedido,this);
        rv.setAdapter(adapter);

        vistaPedido = new VistaPedido(this);
       controladorPedido = new ControladorPedido(new MyListener(vistaPedido));
        vistaPedido.setControladorPedido(controladorPedido);


    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menupedido,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent = new Intent();
        if(item.getItemId() == R.id.LogOut2) {
            SharedPreferences prefs = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.commit();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.AceptarPedido) {

            if(Listados.listaProductoDelPedido.size() != 0) {

              vistaPedido.MostrarMensaje();
            }else
            {
                vistaPedido.MostrarMensajeError();

            }
        }
        if(item.getItemId() == R.id.Limpiar)
        {
            MyViewHolderPedidos.limpiar();

        }
        return super.onOptionsItemSelected(item);

    }

}
