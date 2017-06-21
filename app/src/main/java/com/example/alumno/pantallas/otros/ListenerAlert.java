package com.example.alumno.pantallas.otros;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

/**
 * Created by Pagano on 17/05/2017.
 */

public class ListenerAlert implements DialogInterface.OnClickListener {

    @Override
    public void onClick(DialogInterface dialog, int which) {

        Log.d("dialog","Click!"+which);
    }

}
