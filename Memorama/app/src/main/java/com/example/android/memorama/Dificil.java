package com.example.android.memorama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class Dificil extends AppCompatActivity {

    private String flags[]={"af", "ag", "ao", "at", "bf", "gh", "gm", "gn", "gq", "gr", "id", "pt", "rw", "sa", "se", "mx"};
    private boolean usedFlags[]=new boolean[flags.length];
    private ImageView places[]=new ImageView[8];
    private boolean usedPlaces[]=new boolean[8];
    int contVolt=0;
    int resp, viewIdAnt, puntos=0, match=0;
    HashMap<Integer, Boolean> selectImgs = new HashMap<Integer, Boolean>();
    TextView tvPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil);
    }




















    public void verSolucion(View view){
        ImageView img=(ImageView)findViewById(R.id.img1);
        int resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img2);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img3);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img4);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img5);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img6);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img7);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img8);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img9);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img10);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img11);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img12);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img13);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img14);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img15);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img16);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img17);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img18);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img19);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img20);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img21);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img22);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img23);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        img=(ImageView)findViewById(R.id.img24);
        resId=(int)img.getTag();
        img.setImageResource(resId);
        Button iniciar=(Button)findViewById(R.id.bIniciar);
        iniciar.setEnabled(true);
    }


    public void iniciarJuego(View view){
        Intent intent=new Intent(this, Medio.class);
        finishAffinity();
        startActivity(intent);
    }







}
