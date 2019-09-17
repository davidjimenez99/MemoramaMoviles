package com.example.android.memorama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Facil extends AppCompatActivity {

    private String flags[]={"af", "ag", "ao", "at", "bf", "gh", "gm", "gn", "gq", "gr", "id", "pt", "rw", "sa", "se", "mx"};
    private boolean usedFlags[]=new boolean[flags.length];
    private ImageView places[]=new ImageView[8];
    private boolean usedPlaces[]=new boolean[8];
    int contVolt=0;
    int resp, viewIdAnt, puntos=0;
    HashMap<Integer, Boolean> selectImgs = new HashMap<Integer, Boolean>();
    TextView tvPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);

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

        for(int i=0;i<4;i++){
            int p, f;
            do{
                f=(int)(Math.random()*flags.length);
            }while(usedFlags[f]);
            do{
                p=(int)(Math.random()*8);
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
                    /*if(i==7)
                        break;*/
                    int x=(int)(Math.random()*8);
                    if(!usedPlaces[x]){
                        int id=(int)places[i].getTag();
                        //places[x].setImageResource(id);
                        places[x].setTag(id);
                        usedPlaces[x]=true;
                        break;
                    }
                    x=(int)(Math.random()*8);
                }
            }
        }



    }


    public void clickImg(View view) throws InterruptedException {
        int viewId=view.getId();
        ImageView img=(ImageView)findViewById(viewId);

        if(selectImgs.containsKey(viewId)){
            System.out.println("ENTRA CONTAINSKEY");
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
            //setImage(img,resId);
            System.out.println("NO ENTRA CONTAINSKEY");
            //resp=(int)view.getTag();
            contVolt++;
        }

        System.out.println("CONTVOLT: "+contVolt);

        ImageView imgAnt=(ImageView)findViewById(viewIdAnt);
        if(contVolt==2){                                            //CHECAR SI SE SOBREESCRIBE resp
            if(resp==(int)view.getTag()){       //SON IGUALES
                System.out.println("ENTRO SON IGUALES");
                puntos++;
                tvPuntos=(TextView)findViewById(R.id.tvPuntos);
                tvPuntos.setText("Puntos: "+puntos);
                img.setEnabled(false);
                imgAnt.setEnabled(false);
                contVolt=0;
            }
            else{                               //NO SON IGUALES
                System.out.println("ENTRO NO SON IGUALES");
                //TimeUnit.SECONDS.sleep(1);                          //ESPERAR 1 SEGUNDO Y SE VOLTEA
                img.setImageResource(R.drawable.android);
                imgAnt.setImageResource(R.drawable.android);
                contVolt=0;
                selectImgs.remove(viewId);
            }
        }



        //System.out.println("imgTAG: "+img.getTag());
        viewIdAnt=view.getId();
        resp=(int)view.getTag();
        //System.out.println("VIEWIDANT: "+viewIdAnt);
        //System.out.println("RESP: "+resp);
        //System.out.println("ESPERANDO ANTES DE SETIMAGERESOUCE");
        //TimeUnit.SECONDS.sleep(2);
    }


    public void setImage(ImageView img, int resID){
        System.out.println("ENTRO A METODO");
        img.setImageResource(resID);
    }





}
