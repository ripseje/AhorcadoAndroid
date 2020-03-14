package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VolverAJugar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volver_a_jugar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String res = MainActivity.palabraOculta;
        ((TextView) findViewById(R.id.textView7)).setText(res);
    }

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    public void returnGameState(View view){
        Intent ventana = new Intent(this, Seleccion.class);
        startActivity(ventana);
    }
}
