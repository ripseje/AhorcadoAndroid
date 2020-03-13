package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String palabraOculta = "";
    public static int numeroDeFallos = 0;
    public static boolean victoria = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.ventanaJuego, new VentanaAhorcado()).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        palabraOculta = eligePalabra();
        String barras = "";
        for (int i = 0; i < palabraOculta.length(); i++) {
            barras += "_ ";
        }
        ((TextView) findViewById(R.id.palabraConGuiones)).setText(barras);
    }

    public void botonPulsado (View vista){
        Button boton = findViewById(vista.getId());
        boton.setVisibility(View.INVISIBLE);
        chequeaLetra(boton.getText().toString());
    }

    private void chequeaLetra(String letra){
        letra = letra.toUpperCase();
        ImageView imagenAhorcado = ((ImageView) findViewById(R.id.imagenAhorcado));
        TextView textoConGuiones = ((TextView) findViewById(R.id.palabraConGuiones));
        String palabraConGuiones = textoConGuiones.getText().toString();

        boolean acierto = false;

        for(int i=0; i<palabraOculta.length(); i++){
            if(palabraOculta.charAt(i) == letra.charAt(0) && !victoria){
                palabraConGuiones = palabraConGuiones.substring(0, 2*i) + letra + palabraConGuiones.substring(2*i+1);
                acierto = true;
            }
        }
        if(!palabraConGuiones.contains("_")){
            imagenAhorcado.setImageResource(R.drawable.acertastetodo);
            numeroDeFallos = 100;
            victoria = true;
            volveraJugar();
        }

        textoConGuiones.setText(palabraConGuiones);

        if(!acierto && !victoria){
            numeroDeFallos++;
            switch (numeroDeFallos){
                case 0 : imagenAhorcado.setImageResource(R.drawable.ahorcado_0); break;
                case 1 : imagenAhorcado.setImageResource(R.drawable.ahorcado_1); break;
                case 2 : imagenAhorcado.setImageResource(R.drawable.ahorcado_2); break;
                case 3 : imagenAhorcado.setImageResource(R.drawable.ahorcado_3); break;
                case 4 : imagenAhorcado.setImageResource(R.drawable.ahorcado_4); break;
                case 5 : imagenAhorcado.setImageResource(R.drawable.ahorcado_5); break;
                case 100 : imagenAhorcado.setImageResource(R.drawable.acertastetodo); break;
                default: imagenAhorcado.setImageResource(R.drawable.ahorcado_fin); victoria = true; volveraJugar(); break;
            }
        }
    }

    private String eligePalabra(){
        String [] listaPalabras = {"HOLA", "COMUNISMO", "PALA", "BETIS",
                "COREA", "POPI", "ANDERE", "POLO", "CASA", "ROPA", "VAYA", "PETO", "PIRUJA", "BRUJA",
                "UNITY", "CORONAVIRUS", "VIRUSSINCORONA", "CHINA", "WIKILEAKS", "ANDROID", "FRAXITO",
                "FIERP", "CHIKIBEIBI", "NARUTO", "FRIKI", "POKEMON", "TRAFALGAR", "LEYES", "HIJOS",
                "AYAYAY", "EZ", "FORNITE", "COUNTER", "ASALTO", "MATAR", "POU"};

        String [] listaDeportesF = {"BOTA", "BALON", "PISTA", "GOL", "GOLF", "SURF", "TABLA", "SKI", "PATIN", "MARCA", "SKATE", "CAMPO", "SALTO", "TENIS", "RED"};
        String [] listaDeportesM = {"CANASTA", "TRIPLE", "TENISTA", "CARRERA", "ARBITRO", "JUGADOR", "MARCAJE", "EQUIPO", "PUBLICO", "MEDALLA", "TROFEO", "GANADOR"};
        String [] listaDeportesD = {"REGLAMENTO", "PUNTUACION", "CORREDOR", "HABILIDAD", "ENTRENAMIENTO", "PERDEDOR", "ALINEACION", "BALONCESTO", "ATLETISMO", "FUTBOLISTA"};

        String [] listaGeoF = {"RIO", "PAIS", "MONTE", "PRADO", "MAR", "GOLFO", "CABO", "ISLA", "VALLE", "LLANO", "CALLE", "VILLA", "PLAYA", "LAGO", "PICO"};
        String [] listaGeoM = {"LLANURA", "BOSQUE", "PANTANO", "SABANA", "RIVERA", "VOLCAN", "MONTAÑA", "CIUDAD", "PUEBLO", "SIERRA", "GLACIAR", "JUNGLA"};
        String [] listaGeoD = {"DESIERTO", "CORDILLERA", "ARCHIPIELAGO", "HEMISFERIO", "PENINSULA", "CONTINENTE", "CORRIENTE", "BIOSFERA", "DEPRESION", "GEOGRAFIA"};

        String [] listaMusicaF = {"LETRA", "PIANO", "VIOLA", "POP", "ROCK", "HOUSE", "DISCO", "CD", "RAP", "TRAP", "TECLA", "REMIX", "BAJO", "NOTAS", "DJ"};
        String [] listaMusicaM = {"SONIDO", "CUERDA", "VIENTO", "TAMBOR", "CANCION", "BONGOS", "TECHNO", "BATERIA", "FLAUTA", "TECLADO", "PUBLICO", "MAESTRO"};
        String [] listaMusicaD = {"PENTAGRAMA", "CANTANTE", "GUITARRA", "PERCUSION", "TRIANGULO", "COMPOSITOR", "CONTRABAJO", "HARDCORE", "CONCIERTO", "REGGAETTON"};

        String [] listaCineF = {"CINE", "SALA", "ACTOR", "GUION", "FX", "SAGA", "BANDA", "OST", "CAMEO", "CROMA", "TOMA", "CORTE", "GAG", "PLANO", "SERIE"};
        String [] listaCineM = {"SONIDO", "CAMARA", "REPARTO", "ACCION", "SUSPENSE", "COMEDIA", "ROMANCE", "FICCION", "BLOOPER", "ASIENTO", "RODAJE", "ACTRIZ"};
        String [] listaCineD = {"PALOMITAS", "DIRECTOR", "PRODUCTOR", "MAQUILLAJE", "VESTUARIO", "ESCENARIO", "FRANQUICIA", "TRIOLOGIA", "CREDITOS", "DECORADOS"};

        String [] listaTecnoF = {"PC", "APP", "APPLE", "BLOG", "WEB", "CACHE", "IOS", "CHIP", "PLACA", "BYTE", "HOST", "JAVA", "LINUX", "LAN", "RAM"};
        String [] listaTecnoM = {"ANDROID", "BUSCADOR", "CODIGO", "HACKER", "CONSOLA", "ONLINE", "AMAZON", "BOOLEAN", "PUERTO", "TECLADO", "PANTALLA", "WEBCAM"};
        String [] listaTecnoD = {"ACTUALIZAR", "ADJUNTAR", "ALGORITMO", "ANTIVIRUS", "ORDENADOR", "INTERNET", "VARIABLE", "DESCARGA", "ESCRITORIO", "MEMORIA"};

        String [] bonus = {"JARX", "SEJE", "ELECTROENCEFALOGRAMA", "ACAB", "PERRA", "BADBUNNY",
                            "POSCA", "PIEZOTE", "HAMUD", "GEOMETRYDASH", "LIGADELEYENDAS",
                            "MARICON", "CORONAVIRUS", "BIENBACANO", "BONUS", "PITUFOS"};

        Random aleatorio = new Random();
        if(Seleccion.bon){
            int posicion = aleatorio.nextInt(bonus.length);
            return bonus[posicion].toUpperCase();
        }
        if(Seleccion.faz){
            if(Seleccion.dep){
                int posicion = aleatorio.nextInt(listaDeportesF.length);
                return listaDeportesF[posicion].toUpperCase();
            } else if(Seleccion.geo){
                int posicion = aleatorio.nextInt(listaGeoF.length);
                return listaGeoF[posicion].toUpperCase();
            } else if(Seleccion.mus){
                int posicion = aleatorio.nextInt(listaMusicaF.length);
                return listaMusicaF[posicion].toUpperCase();
            } else if(Seleccion.cin){
                int posicion = aleatorio.nextInt(listaCineF.length);
                return listaCineF[posicion].toUpperCase();
            } else if(Seleccion.tec){
                int posicion = aleatorio.nextInt(listaTecnoF.length);
                return listaTecnoF[posicion].toUpperCase();
            }
        }
        if(Seleccion.med){
            if(Seleccion.dep){
                int posicion = aleatorio.nextInt(listaDeportesM.length);
                return listaDeportesM[posicion].toUpperCase();
            } else if(Seleccion.geo){
                int posicion = aleatorio.nextInt(listaGeoM.length);
                return listaGeoM[posicion].toUpperCase();
            } else if(Seleccion.mus){
                int posicion = aleatorio.nextInt(listaMusicaM.length);
                return listaMusicaM[posicion].toUpperCase();
            } else if(Seleccion.cin){
                int posicion = aleatorio.nextInt(listaCineM.length);
                return listaCineM[posicion].toUpperCase();
            } else if(Seleccion.tec){
                int posicion = aleatorio.nextInt(listaTecnoM.length);
                return listaTecnoM[posicion].toUpperCase();
            }
        }
        if(Seleccion.dif){
            if(Seleccion.dep){
                int posicion = aleatorio.nextInt(listaDeportesD.length);
                return listaDeportesD[posicion].toUpperCase();
            } else if(Seleccion.geo){
                int posicion = aleatorio.nextInt(listaGeoD.length);
                return listaGeoD[posicion].toUpperCase();
            } else if(Seleccion.mus){
                int posicion = aleatorio.nextInt(listaMusicaD.length);
                return listaMusicaD[posicion].toUpperCase();
            } else if(Seleccion.cin){
                int posicion = aleatorio.nextInt(listaCineD.length);
                return listaCineD[posicion].toUpperCase();
            } else if(Seleccion.tec){
                int posicion = aleatorio.nextInt(listaTecnoD.length);
                return listaTecnoD[posicion].toUpperCase();
            }
        }
        int posicion = aleatorio.nextInt(bonus.length);
        return bonus[posicion].toUpperCase();
    }

    public void volveraJugar(){
        Seleccion.dif = false;
        Seleccion.faz = false;
        Seleccion.med = false;
        Seleccion.dif = false;
        Seleccion.bon = false;
        Seleccion.dep = false;
        Seleccion.geo = false;
        Seleccion.mus = false;
        Seleccion.cin = false;
        Seleccion.tec = false;
        numeroDeFallos = 0;
        victoria = false;
        Intent ventana = new Intent(this, VolverAJugar.class);
        startActivity(ventana);
    }
}
