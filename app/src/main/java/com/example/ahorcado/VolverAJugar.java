package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VolverAJugar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volver_a_jugar);
        if(!MainActivity.victoria){
            ((ImageView) findViewById(R.id.imageView)).setImageResource(R.drawable.x);
        }
        else{
            ((ImageView) findViewById(R.id.imageView)).setImageResource(R.drawable.tick);
            MainActivity.victoria = false;
        }
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
