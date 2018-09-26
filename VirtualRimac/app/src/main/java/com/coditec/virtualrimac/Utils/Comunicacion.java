package com.coditec.virtualrimac.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by PC USER on 22/05/2018.
 */

public class Comunicacion {
    private static final String LOG_COMUNICACION = "Comunicación";
    private static Comunicacion instance = null;
    private static Context mContext = null;
    protected Comunicacion() {
    }
    public static Comunicacion getInstance(Context context){
        mContext = context;
        if(instance == null) {
            instance = new Comunicacion();
        }
        return instance;
    }

    public static void llamar() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:017080000"));
        mContext.startActivity(intent);
    }

    public static void ubicar(){
        ubicar("geo:-12.132447, -76.980847?q=-12.132447, -76.980847(Museo de Historia Natural \"Vera Alleman Haeghebaert\")");
    }

    public static void ubicar(String geo){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geo));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }


    public static void enviarCorreo(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:museo@urp.edu.pe"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public static void abrirNavegador(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
