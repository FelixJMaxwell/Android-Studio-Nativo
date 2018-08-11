package com.thefallingboy.a22_miveintidosavaapp_reproductordemusica;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView imgview;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        imgview = (ImageView) findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);
    }

    public void PlayPause(View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view){
        if (vectormp[posicion] != null){
            vectormp[posicion].stop();

            arreglarCanciones();
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            imgview.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    public void repetir(View view){
        if (repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        }else{
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    public void siguiente(View view){
        if (posicion < vectormp.length - 1){

            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                cambiarPortada();
                vectormp[posicion].start();
            }else{
                posicion++;
                cambiarPortada();
            }

        }else{
            Toast.makeText(this, "No hay mas caciones", Toast.LENGTH_SHORT).show();
        }
    }

    public void anterior(View view){
        if (posicion >= 1){

            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                arreglarCanciones();
                posicion--;
                cambiarPortada();
                vectormp[posicion].start();
            }else{
                posicion--;
                cambiarPortada();
            }

        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

    public void cambiarPortada(){
        if (posicion == 0){
            imgview.setImageResource(R.drawable.portada1);
        }else if(posicion == 1){
            imgview.setImageResource(R.drawable.portada2);
        }else if(posicion == 2){
            imgview.setImageResource(R.drawable.portada3);
        }
    }

    public void arreglarCanciones(){
        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);
    }
}
