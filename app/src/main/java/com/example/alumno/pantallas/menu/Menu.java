package com.example.alumno.pantallas.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CheckBox;

import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.pedido.Pedidos;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private ControladorMenu controladorMenu;
    private VistaMenu vistaMenu;

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
        controladorMenu = new ControladorMenu(vistaMenu,modeloMenu,this);
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
            listaProducto = controladorMenu.getListaPrincipal(listaProducto);

            adapter = new MyAdapter(listaProducto,this);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);

        }
        if(item.getItemId() == R.id.bebida) {
            Log.d("BEBIDA", "opcion del menu");

            listaProducto = controladorMenu.getListaBebidas(listaProducto);


            adapter = new MyAdapter(listaProducto,this);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);

        }
        if(item.getItemId() == R.id.snacks) {

            listaProducto =controladorMenu.getListaSnack(listaProducto);
            Log.d("snacks", "opcion del menu");

            adapter = new MyAdapter(listaProducto,this);
            rv.setAdapter(adapter);
            return super.onOptionsItemSelected(item);

        }
        if(item.getItemId() == R.id.LogOut) {
            controladorMenu.logOut();
        }
        if(item.getItemId() == R.id.VerPedido) {

            vistaMenu.enviandoPedido();

        }
        if(item.getItemId() == android.R.id.home) {
            controladorMenu.volverAlLogin();
        }

        return false;

    }


}
