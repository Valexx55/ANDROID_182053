package com.example.miprimeraapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * ESTA SOLUCIÓN ESTÁ INSPIRADA POR EL NOVIO DE SHAKIRA XD
 */

public class MiLinearLayout extends LinearLayout {

    private boolean tocado;

    public MiLinearLayout(Context context) {

        super(context);
        this.tocado = false;
    }

    public MiLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.tocado = false;
    }

    public MiLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.tocado = false;
    }

    public boolean isTocado() {
        return tocado;
    }

    public void setTocado(boolean tocado) {
        this.tocado = tocado;
    }
}
