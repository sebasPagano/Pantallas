package com.example.alumno.pantallas;

import android.util.Log;
import android.util.Xml;

import com.example.alumno.pantallas.pojo.Persona;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sepagano on 15/6/2017.
 */

public class XmlParse {

    public static List<Persona> obtenerPersonas(String xml)
    {
        List<Persona> listaPersonas = new ArrayList<>();

        XmlPullParser xmlPullParser = Xml.newPullParser();

        try {
            xmlPullParser.setInput(new StringReader(xml));
            int event = xmlPullParser.getEventType();

            while(event!= XmlPullParser.END_DOCUMENT)
            {
                if(event == XmlPullParser.START_TAG)
                {
                    if(xmlPullParser.getName().equals("Persona"))
                    {
                        Persona p = new Persona();
                        p.setMail(xmlPullParser.getAttributeValue(null,"nombre"));
                        p.setClave(xmlPullParser.getAttributeValue(null,"clave"));

                        listaPersonas.add(p);
                    }
                }
                event = xmlPullParser.next();
            }

        }
        catch (Exception ex)
        {
            Log.d("Error",ex.getMessage());

        }


        return listaPersonas;
    }
}
