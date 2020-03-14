package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    public void dejarInicio(View view){
        Intent ventana = new Intent(this, Seleccion.class);
        startActivity(ventana);
    }
}
