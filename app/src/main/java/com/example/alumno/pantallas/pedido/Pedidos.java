package com.example.alumno.pantallas.pedido;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumno.pantallas.ListenerAlert;
import com.example.alumno.pantallas.MiDialogo;
import com.example.alumno.pantallas.MyListener;
import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Producto;

import java.util.List;
import java.util.Set;

public class Pedidos extends AppCompatActivity {

    ControladorPedido controladorPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        MyAdapterPedidos adapter = new MyAdapterPedidos(Listados.listaProductoDelPedido,this);
        rv.setAdapter(adapter);

        VistaPedido vistaPedido = new VistaPedido(this);
       controladorPedido = new ControladorPedido(new MyListener(vistaPedido));
        vistaPedido.setControladorPedido(controladorPedido);

        TextView cantidad = (TextView) findViewById(R.id.cantidad2);
        cantidad.setText(String.valueOf(Listados.listaProductoDelPedido.size()));
        TextView precio = (TextView) findViewById(R.id.sumaPrecio2);
        double suma = 0;

        for (Producto prod: Listados.listaProductoDelPedido)
        {
            suma = suma + prod.getPrecio();
        }
        precio.setText(String.valueOf(suma));




        /*MiDialogo di = new MiDialogo();
        di.show(getFragmentManager(),"cualquierCosa");*/

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

        if(item.getItemId() == R.id.AceptarPedido) {

            View v = this.getLayoutInflater().inflate(R.layout.activity_pedido, null);
            controladorPedido.setView(v);
            if(Listados.listaProductoDelPedido.size() != 0) {
                Log.d("cantida",""+Listados.listaProductoDelPedido.size());
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Enviado!");
                builder.setMessage("Aceptado pedido");
                ListenerAlert l = new ListenerAlert();
                builder.setPositiveButton(("OK"),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                controladorPedido.irAMenu();
                            }
                        });


                AlertDialog ad = builder.create();
                ad.show();
            }else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("No puede enviar 0 productos!");
                builder.setMessage("No tiene elementos");
                ListenerAlert l = new ListenerAlert();
                builder.setPositiveButton(("OK"),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                controladorPedido.irAMenu();
                            }
                        });
                AlertDialog ad = builder.create();
                ad.show();

            }


        }
        if(item.getItemId() == R.id.Limpiar)
        {
            MyViewHolderPedidos.limpiar();

        }

        return super.onOptionsItemSelected(item);


    }

}
