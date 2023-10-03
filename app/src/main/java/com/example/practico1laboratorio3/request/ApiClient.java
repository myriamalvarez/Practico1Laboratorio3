package com.example.practico1laboratorio3.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.practico1laboratorio3.modelo.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context){
        if(sp==null){
            sp = context.getSharedPreferences("datos.xml", 0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", usuario.getDni());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("email", usuario.getEmail());
        editor.putString("password", usuario.getPassword());
        editor.commit();

    }

    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String nombre = sp.getString("nombre", "sin dato");
        String apellido = sp.getString("apellido", "sin dato");
        String email = sp.getString("email", "sin dato");
        String password = sp.getString("password", "sin dato");

        Usuario usuario = new Usuario(dni, nombre, apellido, email, password);
        return usuario;
    }

    public static Usuario login(Context context, String mail, String pass){
        Usuario usuario = null;
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String nombre = sp.getString("nombre", "sin dato");
        String apellido = sp.getString("apellido", "sin dato");
        String email = sp.getString("email", "sin dato");
        String password = sp.getString("password", "sin dato");

        if (email.equals(mail)&&password.equals(pass)){
            usuario = new Usuario(dni, nombre, apellido, email, password);
        }
        return usuario;
    }
}
