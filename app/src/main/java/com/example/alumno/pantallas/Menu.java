package com.example.alumno.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btn = (Button) findViewById(R.id.btnEnviarPedido);
        MyListener listener = new MyListener(this);
        btn.setOnClickListener((View.OnClickListener)listener);

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
        List<Producto> listaProducto = new ArrayList<Producto>();
        List<Producto> listaProducto2 = new ArrayList<Producto>();
        List<Producto> listaProducto3 = new ArrayList<Producto>();

        if(item.getItemId() == R.id.menu) {
            Log.d("MENU", "opcion del menu");


            listaProducto.add(new Producto("Pizza de Mozzarella",(int) 110,R.drawable.mozzarella));
            listaProducto.add(new Producto("Pizza de Fugazetta",(int) 120,R.drawable.fugazza));
            listaProducto.add(new Producto("Pizza Napolitana",(int) 130,R.drawable.napolitana));
            listaProducto.add(new Producto("Empanadas",(int) 300,R.drawable.empanadas));


            MyAdapter adapter = new MyAdapter(listaProducto);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);



        }
        if(item.getItemId() == R.id.bebida) {
            Log.d("BEBIDA", "opcion del menu");

            listaProducto2.add(new Producto("Sprite",(int) 40,R.drawable.sprite));
            listaProducto2.add(new Producto("Coca Cola",(int) 50,R.drawable.cocacola));
            listaProducto2.add(new Producto("Heineken",(int) 60,R.drawable.heineken));


            MyAdapter adapter = new MyAdapter(listaProducto2);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);



        }
        if(item.getItemId() == R.id.snacks) {

            Log.d("snacks", "opcion del menu");
            listaProducto3.add(new Producto("Chizitos",(int) 30,R.drawable.chizitos));
            listaProducto3.add(new Producto("Palitos",(int) 30,R.drawable.palitos));
            listaProducto3.add(new Producto("Nachos con Cheddar",(int) 60,R.drawable.nachos));
            listaProducto3.add(new Producto("Snacks",(int) 30,R.drawable.snacks));



            MyAdapter adapter = new MyAdapter(listaProducto3);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);



        }

        return false;

    }


}
