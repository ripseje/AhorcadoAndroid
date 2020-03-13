package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Seleccion extends AppCompatActivity {

    public static boolean faz = false;
    public static boolean med = false;
    public static boolean dif = false;
    public static boolean bon = false;
    public static boolean dep = false;
    public static boolean geo = false;
    public static boolean mus = false;
    public static boolean cin = false;
    public static boolean tec = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
    }

    public void bonus(View view){
        faz = false;
        med = false;
        dif = false;
        bon = true;
        Intent ventana = new Intent(this, MainActivity.class);
        startActivity(ventana);
    }

    public void chequeaSelecDep(View view){
        dep = true;
        String f = "FÁCIL";
        String m = "NORMAL";
        Button boton = findViewById(view.getId());
        if(boton.getText().toString().equals(f)){
            faz = true;
            med = false;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else if(boton.getText().toString().equals(m)){
            faz = false;
            med = true;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else{
            faz = false;
            med = false;
            dif = true;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        }
    }
    public void chequeaSelecGeo(View view){
        geo = true;
        String f = "FÁCIL";
        String m = "NORMAL";
        Button boton = findViewById(view.getId());
        if(boton.getText().toString().equals(f)){
            faz = true;
            med = false;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else if(boton.getText().toString().equals(m)){
            faz = false;
            med = true;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else{
            faz = false;
            med = false;
            dif = true;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        }
    }
    public void chequeaSelecMus(View view){
        mus = true;
        String f = "FÁCIL";
        String m = "NORMAL";
        Button boton = findViewById(view.getId());
        if(boton.getText().toString().equals(f)){
            faz = true;
            med = false;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else if(boton.getText().toString().equals(m)){
            faz = false;
            med = true;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else{
            faz = false;
            med = false;
            dif = true;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        }
    }
    public void chequeaSelecCine(View view){
        cin = true;
        String f = "FÁCIL";
        String m = "NORMAL";
        Button boton = findViewById(view.getId());
        if(boton.getText().toString().equals(f)){
            faz = true;
            med = false;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else if(boton.getText().toString().equals(m)){
            faz = false;
            med = true;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else{
            faz = false;
            med = false;
            dif = true;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        }
    }
    public void chequeaSelecTec(View view){
        tec = true;
        String f = "FÁCIL";
        String m = "NORMAL";
        Button boton = findViewById(view.getId());
        if(boton.getText().toString().equals(f)){
            faz = true;
            med = false;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else if(boton.getText().toString().equals(m)){
            faz = false;
            med = true;
            dif = false;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        } else{
            faz = false;
            med = false;
            dif = true;
            bon = false;
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        }
    }
}
