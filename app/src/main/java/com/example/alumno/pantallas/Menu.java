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

        List<Pedido> listaPedido = new ArrayList<Pedido>();
        listaPedido.add(new Pedido("Pizza",(int) 30.5));
        listaPedido.add(new Pedido("Pizza",(int) 30.5));
        listaPedido.add(new Pedido("Pizza",(int) 30.5));
        listaPedido.add(new Pedido("Pizza",(int) 30.5));
        listaPedido.add(new Pedido("Pizza",(int) 30.5));
        listaPedido.add(new Pedido("Pizza",(int) 30.5));
        listaPedido.add(new Pedido("Pizza",(int) 30.5));


        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        MyAdapter adapter = new MyAdapter(listaPedido);
        rv.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.nuevo_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.opcion1) {
            Log.d("click", "opcion del menu");
            return super.onOptionsItemSelected(item);
        }
        return false;

    }



}
