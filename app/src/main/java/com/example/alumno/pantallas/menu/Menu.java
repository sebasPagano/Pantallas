package com.example.alumno.pantallas.menu;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.login.ControladorLogin;
import com.example.alumno.pantallas.pedido.Pedidos;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

ControladorMenu controladorMenu;
    VistaMenu vistaMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        if(Listados.listaProductoDelPedido != null) {
            Listados.listaProductoDelPedido.clear();
        }
        vistaMenu =  new VistaMenu(this);
        ModeloMenu modeloMenu = new ModeloMenu();
        controladorMenu = new ControladorMenu(new MyListener(vistaMenu));
        controladorMenu.setModeloMenu(modeloMenu);
        vistaMenu.setControladorMenu(controladorMenu);


    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.nuevo_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent = new Intent();
        List<Producto> listaProducto = new ArrayList<Producto>();

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        MyAdapter adapter = null;


        if(item.getItemId() == R.id.menu) {
            Log.d("MENU", "opcion del menu");

            listaProducto.add(new Producto("Pizza de Mozzarella",(int) 110,R.drawable.mozzarella));
            listaProducto.add(new Producto("Pizza de Fugazetta",(int) 120,R.drawable.fugazza));
            listaProducto.add(new Producto("Pizza Napolitana",(int) 130,R.drawable.napolitana));
            listaProducto.add(new Producto("Empanadas",(int) 300,R.drawable.empanadas));

            adapter = new MyAdapter(listaProducto,this);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);

        }
        if(item.getItemId() == R.id.bebida) {
            Log.d("BEBIDA", "opcion del menu");

            listaProducto.add(new Producto("Sprite",(int) 40,R.drawable.sprite));
            listaProducto.add(new Producto("Coca Cola",(int) 50,R.drawable.cocacola));
            listaProducto.add(new Producto("Heineken",(int) 60,R.drawable.heineken));

            adapter = new MyAdapter(listaProducto,this);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);

        }
        if(item.getItemId() == R.id.snacks) {

            Log.d("snacks", "opcion del menu");
            listaProducto.add(new Producto("Chizitos",(int) 30,R.drawable.chizitos));
            listaProducto.add(new Producto("Palitos",(int) 30,R.drawable.palitos));
            listaProducto.add(new Producto("Nachos con Cheddar",(int) 60,R.drawable.nachos));
            listaProducto.add(new Producto("Snacks",(int) 30,R.drawable.snacks));

            adapter = new MyAdapter(listaProducto,this);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);

        }
        if(item.getItemId() == R.id.LogOut) {
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.VerPedido) {
            intent.setClass(this, Pedidos.class);
            startActivity(intent);
        }
        if(item.getItemId() == android.R.id.home) {
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        }

        return false;

    }


}
