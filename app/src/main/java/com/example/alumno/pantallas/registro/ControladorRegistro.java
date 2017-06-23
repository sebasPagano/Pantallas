package com.example.alumno.pantallas.registro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.alumno.pantallas.R;
import com.example.alumno.pantallas.otros.ListenerAlert;
import com.example.alumno.pantallas.otros.MyListener;
import com.example.alumno.pantallas.login.MainActivity;
import com.example.alumno.pantallas.pojo.Listados;
import com.example.alumno.pantallas.pojo.Persona;

/**
 * Created by sepagano on 30/5/2017.
 */

public class ControladorRegistro {

    private ModeloRegistro modelo;
    private VistaRegistro vistaRegistro;
    private ModeloRegistro modeloRegistro;
    private boolean valida;
    public ControladorRegistro(VistaRegistro vistaRegistro, ModeloRegistro modeloRegistro)
    {
        this.vistaRegistro = vistaRegistro;
        this.modeloRegistro = modeloRegistro;


    }



    public boolean Validar(String nombre, String apellido, int dni, String clave, String mail)
    {
        if(nombre!=null && apellido!=null && dni>10000000 && clave!=null && mail!=null) {
            return true;
        }
        return false;
    }

    public void volverAlLogin(View v, String nombre, String apellido, int dni, String clave, String mail)
    {
        valida = this.Validar(nombre,apellido,dni,clave,mail);
        Log.d("valida","validaa"+valida);
        if(valida) {
            Log.d("valida","validaa"+valida);
            Listados.listaPersonas.add(new Persona(nombre,apellido,dni,mail,clave));
            Context con = v.getContext();
            Intent i = new Intent(con, MainActivity.class);
            con.startActivity(i);
            }
            else
            {
                Log.d("valida","no validaa"+valida);
            }
    }

    public boolean isValida() {
        return valida;
    }

    public void setModeloRegistro(ModeloRegistro modelo)
    {
        this.modelo = modelo;
    }

    public void Registrar()
    {
        String apellido = vistaRegistro.editTextApellido.getText().toString();
        String nombre = vistaRegistro.editTextNombre.getText().toString();
        String clave = vistaRegistro.editTextClave.getText().toString();
        String reingreseClave = vistaRegistro.editTextReingreseClave.getText().toString();
        String mail = vistaRegistro.editTextMail.getText().toString();
        View v = vistaRegistro.v;
        int dni;

        if(vistaRegistro.editTextDNI.getText().toString().equals("")) {
            dni = 0;
        }else
        {
            dni = Integer.parseInt(vistaRegistro.editTextDNI.getText().toString());
        }

        if(clave.equals(reingreseClave)) {


            this.volverAlLogin(v,nombre,apellido,dni,clave,mail);
        }else
        {
            this.MostrarMensajeClaveDiferente();
        }
        if(!this.isValida() && clave.equals(reingreseClave) || clave.equals(""))
        {
            this.MostrarMensajeErrorCamposVacios();
        }

    }
    public void MostrarMensajeErrorCamposVacios() {
        String alerta = vistaRegistro.a.getString(R.string.alerta);
        String aceptar = vistaRegistro.a.getString(R.string.aceptar);
        String mensajeError = vistaRegistro.a.getString(R.string.mensajeErrorRegistro);

        AlertDialog.Builder builder = new AlertDialog.Builder(vistaRegistro.a);
        builder.setTitle(alerta + "!!!");
        builder.setMessage(mensajeError);
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar, l);
        AlertDialog ad = builder.create();
        ad.show();
    }

    public void MostrarMensajeClaveDiferente()
    {
        String alerta = vistaRegistro.a.getString(R.string.alerta);
        String aceptar = vistaRegistro.a.getString(R.string.aceptar);
        String mensajeError = vistaRegistro.a.getString(R.string.mensajeErrorClaves);

        AlertDialog.Builder builder = new AlertDialog.Builder(vistaRegistro.a);
        builder.setTitle(alerta+"!!!");
        builder.setMessage(mensajeError);
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton(aceptar, l);
        AlertDialog ad = builder.create();
        ad.show();
    }

}