package com.example.alumno.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.nuevo_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        List<Pedido> listaPedido = new ArrayList<Pedido>();

        if(item.getItemId() == R.id.menu) {
            Log.d("click", "opcion del menu");


            listaPedido.add(new Pedido("Pizza de Mozzarella",(int) 110));
            listaPedido.add(new Pedido("Pizza de Fugazetta",(int) 120));
            listaPedido.add(new Pedido("Pizza Napolitana",(int) 130));
            listaPedido.add(new Pedido("Empanadas",(int) 300));



            MyAdapter adapter = new MyAdapter(listaPedido);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);



        }
        if(item.getItemId() == R.id.cafe) {
            Log.d("click", "opcion del menu");

            listaPedido.add(new Pedido("Cafe",(int) 40));
            listaPedido.add(new Pedido("Coca Cola",(int) 50));
            listaPedido.add(new Pedido("Cerveza",(int) 60));


            MyAdapter adapter = new MyAdapter(listaPedido);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);



        }
        if(item.getItemId() == R.id.cafe) {
            Log.d("click", "opcion del menu");

            listaPedido.add(new Pedido("Cafe",(int) 40));
            listaPedido.add(new Pedido("Coca Cola",(int) 50));
            listaPedido.add(new Pedido("Cerveza",(int) 60));


            MyAdapter adapter = new MyAdapter(listaPedido);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);



        }
        if(item.getItemId() == R.id.snacks) {


            listaPedido.add(new Pedido("Chisitos",(int) 30));
            listaPedido.add(new Pedido("Palitos",(int) 30));
            listaPedido.add(new Pedido("Nachos con Cheddar",(int) 60));


            MyAdapter adapter = new MyAdapter(listaPedido);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);



        }
        return false;

    }



}
