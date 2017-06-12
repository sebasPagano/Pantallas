package com.example.alumno.pantallas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by Pagano on 17/05/2017.
 */

public class MiDialogo extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Enviado!");
        builder.setMessage("Aceptado pedido");
        ListenerAlert l = new ListenerAlert();
        builder.setPositiveButton("Aceptar", l);


// Creamos el dialogo
        AlertDialog ad = builder.create();
        return ad;
    }

}
