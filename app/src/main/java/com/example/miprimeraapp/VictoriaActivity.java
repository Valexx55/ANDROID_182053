package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class VictoriaActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoria);

        ImageView imagenView = findViewById(R.id.carrusel);
        imagenView.setBackgroundResource(R.drawable.secuencia_victoria);
        this.animationDrawable = (AnimationDrawable) imagenView.getBackground();
        this.animationDrawable.start();
    }
}
