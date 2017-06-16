package com.example.alumno.pantallas.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pagano on 03/05/2017.
 */

public class Persona {

    private String nombre;
    private String apellido;
    private int dni;
    private String mail;
    private String clave;

    public Persona()
    {}
    public Persona(String mail, String clave)
    {

        this.mail = mail;
        this.clave = clave;
    }

    public Persona(String nombre, String apellido, int dni,String mail, String clave)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.clave = clave;
    }

    public String getMail()
    {
        return this.mail;
    }

    public String getClave()
    {
        return this.clave;
    }


    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }


    public int getDni()
    {
        return this.dni;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass()))
        {

            Persona p1 = (Persona) obj;
            if(this.nombre.equals(p1.nombre) && this.apellido.equals(p1.apellido)
                    && this.clave.equals(p1.clave)&&  this.mail.equals(p1.mail) && this.dni == p1.dni)
            {
                return true;
            }




        }else
        {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int numero = 31;
        int resultado = 1;

        if(dni != 0)
        {
            resultado = numero* resultado + dni;
        }
        if(nombre!=null)
        {
            resultado = numero * resultado + nombre.hashCode();
        }
        if(apellido!=null)
        {
            resultado = numero * resultado + apellido.hashCode();
        }
        if(mail!=null)
        {
            resultado = numero * resultado + mail.hashCode();

        }
        if(clave!=null)
        {
            resultado = numero * resultado + clave.hashCode();

        }

        return resultado;

    }
    @Override
    public String toString()
    {
        return this.apellido+"-"+ this.nombre+"-"+ this.clave+"-"+this.dni+"-"+this.mail;
    }
}
