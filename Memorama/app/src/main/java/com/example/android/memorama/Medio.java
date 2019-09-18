package com.example.android.memorama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;

public class Medio extends AppCompatActivity {

    private String flags[]={"af", "ag", "ao", "at", "bf", "gh", "gm", "gn", "gq", "gr", "id", "pt", "rw", "sa", "se", "mx"};
    private boolean usedFlags[]=new boolean[flags.length];
    private ImageView places[]=new ImageView[16];
    private boolean usedPlaces[]=new boolean[16];
    int contVolt=0;
    int resp, viewIdAnt, puntos=0, match=0;
    HashMap<Integer, Boolean> selectImgs = new HashMap<Integer, Boolean>();
    TextView tvPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medio);



        Arrays.fill(usedFlags,false);
        Arrays.fill(usedPlaces,false);
        places[0]=(ImageView)findViewById(R.id.img1);
        places[1]=(ImageView)findViewById(R.id.img2);
        places[2]=(ImageView)findViewById(R.id.img3);
        places[3]=(ImageView)findViewById(R.id.img4);
        places[4]=(ImageView)findViewById(R.id.img5);
        places[5]=(ImageView)findViewById(R.id.img6);
        places[6]=(ImageView)findViewById(R.id.img7);
        places[7]=(ImageView)findViewById(R.id.img8);
        places[8]=(ImageView)findViewById(R.id.img9);
        places[9]=(ImageView)findViewById(R.id.img10);
        places[10]=(ImageView)findViewById(R.id.img11);
        places[11]=(ImageView)findViewById(R.id.img12);
        places[12]=(ImageView)findViewById(R.id.img13);
        places[13]=(ImageView)findViewById(R.id.img14);
        places[14]=(ImageView)findViewById(R.id.img15);
        places[15]=(ImageView)findViewById(R.id.img16);

        for(int i=0;i<8;i++){
            int p, f;
            do{
                f=(int)(Math.random()*flags.length);
            }while(usedFlags[f]);
            do{
                p=(int)(Math.random()*16);
            }while(usedPlaces[p]);
            int resID=getResources().getIdentifier(flags[f],"drawable",getPackageName());
            //places[p].setImageResource(resID);
            places[p].setTag(resID);
            usedFlags[f]=true;
            usedPlaces[p]=true;
        }

        boolean usedPlacesTmp[]=usedPlaces.clone();

        for(int i=0;i<usedPlacesTmp.length;i++){
            if(usedPlacesTmp[i]){
                while(true){
                    int x=(int)(Math.random()*16);
                    if(!usedPlaces[x]){
                        int id=(int)places[i].getTag();
                        //places[x].setImageResource(id);
                        places[x].setTag(id);
                        usedPlaces[x]=true;
                        break;
                    }
                    x=(int)(Math.random()*16);
                }
            }
        }
    }


    public void clickImg(View view){
        int viewId=view.getId();
        ImageView img=(ImageView)findViewById(viewId);

        if(selectImgs.containsKey(viewId)){
            img.setImageResource(R.drawable.android);
            selectImgs.remove(viewId);
            resp=0;
            contVolt--;
        }
        else{
            selectImgs.put(viewId, true);
            int resId=(int)img.getTag();
            System.out.println("resID: "+resId);
            img.setImageResource(resId);
            contVolt++;
        }

        if(contVolt<0)
            contVolt=0;

        ImageView imgAnt=(ImageView)findViewById(viewIdAnt);

        if(contVolt==2){
            if(resp==(int)view.getTag()){       //SON IGUALES
                puntos++;
                tvPuntos=(TextView)findViewById(R.id.tvPuntos);
                tvPuntos.setText("Puntos: "+puntos);
                img.setEnabled(false);
                imgAnt.setEnabled(false);
                contVolt=0;
                match++;
            }
            else{                               //NO SON IGUALES
                //TimeUnit.SECONDS.sleep(1);                          //ESPERAR 1 SEGUNDO Y SE VOLTEA
                img.setImageResource(R.drawable.android);
                imgAnt.setImageResource(R.drawable.android);
                contVolt=0;
                selectImgs.remove(viewId);
                selectImgs.remove(viewIdAnt);
            }
        }

        viewIdAnt=view.getId();
        resp=(int)view.getTag();

        //System.out.println(Arrays.asList(selectImgs));


        if(match==8){
            Button iniciar=(Button)findViewById(R.id.bIniciar);
            iniciar.setEnabled(true);
        }
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
        Button iniciar=(Button)findViewById(R.id.bIniciar);
        iniciar.setEnabled(true);
    }


    public void iniciarJuego(View view){
        Intent intent=new Intent(this, Medio.class);
        finishAffinity();
        startActivity(intent);
    }








}
