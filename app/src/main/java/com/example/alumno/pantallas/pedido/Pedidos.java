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

import com.example.alumno.pantallas.menu.ModeloMenu;
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
        ModeloPedido modeloPedido = new ModeloPedido();
       controladorPedido = new ControladorPedido(vistaPedido,modeloPedido,this);
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
           controladorPedido.logOut();
        }
        if(item.getItemId() == R.id.AceptarPedido) {
            vistaPedido.enviarPedido();
        }

        if(item.getItemId() == R.id.Limpiar)
        {
            MyViewHolderPedidos.limpiar();

        }
        return super.onOptionsItemSelected(item);

    }

}
