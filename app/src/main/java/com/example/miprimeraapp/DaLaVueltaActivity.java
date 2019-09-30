package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DaLaVueltaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (savedInstanceState==null)
        {
            Log.d("MIAPP", "No hay nada guardado, entró por 1ª vez");
        }
        else {
            Log.d("MIAPP", "Hay cosas guardadas");
            //coger las cosas guardadas
            String palabra_guardada = savedInstanceState.getString("caja_salida");
            TextView caja_salida = findViewById(R.id.caja_salida);
            caja_salida.setText(palabra_guardada);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MIAPP", "Puedo guardar cositas que se perderán por el cambio de orientación");
        Log.d("MIAPP", "OnSaveInstanceState");
        //1 obtener la caja de salida
        TextView caja_salida = findViewById(R.id.caja_salida);
        //2 obtener el texto
        String palabra_reves = caja_salida.getText().toString();
        //3 GUARDAR en el BUNDLE
        outState.putString("caja_salida",palabra_reves);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MIAPP", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MIAPP", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MIAPP", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MIAPP", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MIAPP", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MIAPP", "onRestart");
    }

    public void darLaVuelta(View view) {
        //TODO 1 OBTENER TEXTO INTRODUCIDO EN CAJA 1
        EditText cajain = findViewById(R.id.caja_origen);
        String texto_introducido = cajain.getText().toString();
        // 2 DAR LA VUELTA AL TEXTO
        StringBuilder stringBuilder = new StringBuilder(texto_introducido);
        String cadena_volteada = stringBuilder.reverse().toString();
        // 3 MOSTRARLO EN LA CAJA 2
        TextView caja_salida = findViewById(R.id.caja_salida);
        caja_salida.setText(cadena_volteada);
    }


}
