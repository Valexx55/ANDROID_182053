package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;


public class VersionActivity extends AppCompatActivity {

    private TextView caja_version;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("etiqueta", "APP iniciada");//nivel DEBUG que no es muy importante
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("etiqueta", "pantalla cargada");
        this.caja_version = this.findViewById(R.id.caja_version);

    }

    private String getVersionName () throws IllegalAccessException
    {
        String nombre_version = null;
        boolean encontrado = false;
        Field[] fields = null;
        Field version_actual = null;
        int version_numerica_actual = 0;
        int posicion_actual = 0;

        fields = Build.VERSION_CODES.class.getFields();//obtenemos las versiones
        do {
            version_actual = fields[posicion_actual];//obtengo version actual
            version_numerica_actual = version_actual.getInt(Build.VERSION_CODES.class); //el número de la version
            if (version_numerica_actual == Build.VERSION.SDK_INT)//hemos encontrado la version
            {
                nombre_version = version_actual.getName();
                encontrado = true;
            }
            else {
                posicion_actual = posicion_actual + 1; //posicion_actual ++ voy a la siguiente
            }
        } while (!encontrado);//hasta que no encuentre la versión.

        return  nombre_version;
    }


    private void escribirVersion () {

        String nombre_version = null;
        try {
            nombre_version = getVersionName();
        } catch (IllegalAccessException e) {
            Log.e("etiqueta", "Error al obtener version", e);
        }
        this.caja_version.setText(nombre_version);
    }

    public void botonVerionTocado(View view) {

        escribirVersion();
        Log.d("etiqueta", "Han tocado el botón");
    }
}
