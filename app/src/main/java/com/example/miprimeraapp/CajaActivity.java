package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CajaActivity extends AppCompatActivity {

    private int numero_toques;
    private int n_cajas_tocadas;
    private int color_negro;
    private int total;
    private long tinicial;



    private int obtenerNumeroAleatorio  ()
    {
        int num_aleatorio = 0;

            num_aleatorio = ((int)(Math.random() * 10))+1;

        return num_aleatorio;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja);
        this.color_negro = getResources().getColor(R.color.black);

        //TODO obtener las TextView de mi Layout
        ViewGroup elemento_padre = findViewById(R.id.layout_cajas);
        List<View> l_vistas = findViewsByType(elemento_padre, TextView.class);
        Log.d("MIAPP", "El num de TextViews es " + l_vistas.size());
        //TODO recorrer las cajas de texto y darle un valor numérico aleatorio
        TextView textView = null;
        int n_aleatorio = 0;
        String str_n = null;
        total = 0;
        for (View vista_actual : l_vistas)//for each
        {
            textView = (TextView)vista_actual;//casting de vista a TextView
            n_aleatorio = obtenerNumeroAleatorio();//genero el aleatorio
            total = total + n_aleatorio;
            //total += n_aleatorio;//vpro
            str_n = String.valueOf(n_aleatorio);//convierto el número a su equivalento texto
            textView.setText(str_n);//asigno a la caja de texto el número generado
        }








    }


//num_caja = (int) (Math.random() * 100) + 1;
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
        //LinearLayout linearLayout = (LinearLayout)view;//casting
        if (view.getTag() == null)
        {
            Log.d("MIAPP", "Tocada por primera vez");
            view.setBackgroundColor(color_negro);//pongo negra la caja
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

    public void empezar(View view) {
        Log.d("MIAPP", "Juego iniciado");
        view.setVisibility(View.GONE); //elimino el botón
        Toast toast = Toast.makeText(this, "JUEGO EMPEZADO", Toast.LENGTH_LONG);//compongo el mensaje
        toast.show();//lo muestro

        this.tinicial = System.currentTimeMillis();
    }

    public void probarSolucion(View view) {
        //1 obtener la solución del usuario
        EditText editText = findViewById(R.id.caja_solucion);
        String s_num = editText.getText().toString();
        int solucion_usr = Integer.parseInt(s_num);
        //2 comprobar si es igual al total
        if (solucion_usr==total)
        {
            Log.d("MIAPP", "Ha acertado");
            //calcular el tiempo total, informarle y salir
            long t_final = System.currentTimeMillis();
            long t_total = t_final-this.tinicial;//ms
            int t_segundos = (int)t_total/1000;//lo paso a segundos
            //informo
            Toast mensaje_OK = Toast.makeText(this, "Enhorabuena :)", Toast.LENGTH_LONG);
            mensaje_OK.show();
            //salir
            //finish();
            //TODO TRANSITAR A LA ACTIVIDAD DE VICTORIA
            //preparo el intent
            Intent intent = new Intent(this, VictoriaActivity.class);
            //lanzo
            startActivity(intent);

        }
        else{
            Log.d("MIAPP", "Ha fallado");
            Toast mensaje_KO = Toast.makeText(this, "Has fallao :(", Toast.LENGTH_SHORT);
            mensaje_KO.show();
        }

    }
}
