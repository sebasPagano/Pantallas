package com.example.alumno.pantallas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Pedidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        List<Producto> listaProducto = MyViewHolderPedidos.getlista();

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        MyAdapterPedidos adapter = new MyAdapterPedidos(listaProducto);
        rv.setAdapter(adapter);
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
            Log.d("click", "opcion del menu");
            intent.setClass(this, MainActivity.class);
            startActivity(intent);

            return super.onOptionsItemSelected(item);


        }
        if(item.getItemId() == R.id.LogOut2) {

            return super.onOptionsItemSelected(item);


        }


        return false;

    }

}
