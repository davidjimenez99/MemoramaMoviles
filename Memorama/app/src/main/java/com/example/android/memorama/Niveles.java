package com.example.android.memorama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Niveles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
    }

    public void goToFacil (View view){
        Intent intent = new Intent(this, Facil.class);
        startActivity(intent);
    }
    public void goToMedio (View view){
        Intent intent = new Intent(this, Medio.class);
        startActivity(intent);
    }
    public void goToDificil (View view){
        Intent intent = new Intent(this, Dificil.class);
        startActivity(intent);
    }
}
