package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CajaActivity extends AppCompatActivity {

    private int numero_toques;
    private int n_cajas_tocadas;
    private int color_negro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja);
        this.color_negro = getResources().getColor(R.color.black);
    }



    public void cajaTocada(View view) {
        Log.d("MIAPP", "Caja Tocada");
        numero_toques = numero_toques + 1;
        Log.d("MIAPP", "N toques = "+  numero_toques);
        LinearLayout linearLayout = (LinearLayout)view;//casting
        ColorDrawable color_fondo = (ColorDrawable)linearLayout.getBackground();//obtengo el color de fondo
        int color_caja_actual = color_fondo.getColor();//obtengo el valor color numérico
        if (color_caja_actual != color_negro)
        {
            Log.d("MIAPP", "Tocada por primera vez");
            linearLayout.setBackgroundColor(color_negro);//pongo negra la caja
            n_cajas_tocadas++;
            if (n_cajas_tocadas==8)
            {
                Log.d("MIAPP", "Se han tocado todas");
                finish();
            }

        } else {
            Log.d("MIAPP", "Ya se ha tocado la caja, no hago ná");
        }

    }

//VERSIÓN 3 CON SET TAG
    //TODO mensaje de salida cuando se complete el juego
    public void cajaTocada3(View view) {
        Log.d("MIAPP", "Caja Tocada");
        LinearLayout linearLayout = (LinearLayout)view;//casting
        if (view.getTag() == null)
        {
            Log.d("MIAPP", "Tocada por primera vez");
            linearLayout.setBackgroundColor(color_negro);//pongo negra la caja
            view.setTag(true);
            n_cajas_tocadas++;
            if (n_cajas_tocadas==8)
            {
                Log.d("MIAPP", "Se han tocado todas");
                finish();
            }

        } else {
            Log.d("MIAPP", "Ya se ha tocado la caja, no hago ná");
        }

    }

    /**
     *   private void mostrarLayout(View vista)
     *     {
     *         Log.d(getClass().getCanonicalName(), vista.getClass().getCanonicalName());
     *
     *         if (vista instanceof ViewGroup)
     *         {
     *             ViewGroup viewGroup = (ViewGroup) vista;
     *
     *             for (int i = 0; i<viewGroup.getChildCount(); i++)
     *             {
     *                 View vistahija = viewGroup.getChildAt(i);
     *                 mostrarLayout(vistahija);
     *
     *             }
     *         }
     *     }
     */

    private List<View> findViewsByType (@NonNull ViewGroup vista_raiz, Class tipo_buscado)
      {
          List<View> lvistas = null;
          int nhijos = 0;
          ViewGroup vactual = null;
          View vistahija = null;

          List<ViewGroup> lista_vistas = new ArrayList<ViewGroup>();
          lista_vistas.add(vista_raiz);
          lvistas = new ArrayList<View>();

          for (int i = 0; i<lista_vistas.size(); i++)
          {
              vactual = lista_vistas.get(i);
             Log.d("MIAPP", "Mostrando " + vactual.getClass().getCanonicalName());
              nhijos = vactual.getChildCount();
              for (int j = 0;j<nhijos;j++ )
              {
                  vistahija = vactual.getChildAt(j);
                  if (tipo_buscado.isAssignableFrom(vistahija.getClass()))
                  {
                      lvistas.add(vistahija);
                 }
                 if (vistahija instanceof  ViewGroup)
                 {
                     lista_vistas.add((ViewGroup)vistahija);
     }
                 else
                 {
                     Log.d("MIAPP", "Mostrando " + vistahija.getClass().getCanonicalName());
                 }
             }
         }
         return lvistas;
     }

}
