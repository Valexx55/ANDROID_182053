package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImagenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        //setear imagen
        ImageView imagen_pantera = findViewById(R.id.pantera);
        imagen_pantera.setImageResource(R.drawable.pantera_rosa);

        //TODO ATRIBUTOS DE VISIBILIDAD DE UNA IMAGEN o vista

       // imagen_pantera.setVisibility(View.VISIBLE);//estado original
        imagen_pantera.setVisibility(View.INVISIBLE);//está pero no se vé
        imagen_pantera.setVisibility(View.GONE);//se elimina del XML
        imagen_pantera.setVisibility(View.VISIBLE);//estado original

        
//




        //RESOLUCIONES https://stackoverflow.com/a/37321194

    }

}
