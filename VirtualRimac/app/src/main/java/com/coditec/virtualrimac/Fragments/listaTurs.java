package com.coditec.virtualrimac.Fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coditec.virtualrimac.R;
import com.coditec.virtualrimac.Utils.Comunicacion;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.WelcomeButtonAction;
import com.dexafree.materialList.view.MaterialListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class listaTurs extends Fragment {

    private Context mContext;
    private MaterialListView mListView;

    public listaTurs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_turs, container, false);

        mListView = v.findViewById(R.id.lvTurs);

        mContext = getContext();

        Card card = new Card.Builder(getContext())
                .withProvider(new CardProvider<>())
                .setLayout(R.layout.material_welcome_card_layout)
                .setTitle("Tour Peatonal")
                .setTitleColor(Color.WHITE)
                .setDescription("Punto de partida: Colegio Ricardo Bentin")
                .setDescriptionColor(Color.WHITE)
                .setSubtitle("Precio: s/. 15.00 | 5.00$ ")
                .setSubtitleColor(Color.WHITE)
                .setBackgroundColor(Color.parseColor("#FF4081"))
                .addAction(R.id.ok_button, new WelcomeButtonAction(getContext())
                        .setText("Contactar!")
                        .setTextColor(Color.WHITE)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("http://www.munirimac.gob.pe/portal/turismo-2/tour-peatonales/");
                                //Toast.makeText(mContext, "Welcome!", Toast.LENGTH_SHORT).show();
                            }
                        }))
                .endConfig()
                .build();

        Card card2 = new Card.Builder(getContext())
                .withProvider(new CardProvider<>())
                .setLayout(R.layout.material_welcome_card_layout)
                .setTitle("Tour Museos")
                .setTitleColor(Color.WHITE)
                .setDescription("Punto de partida: Puente Santa Rosa")
                .setDescriptionColor(Color.WHITE)
                .setSubtitle("Precio: s/. 5.00 | 2.00$ ")
                .setSubtitleColor(Color.WHITE)
                .setBackgroundColor(Color.parseColor("#FF4081"))
                .addAction(R.id.ok_button, new WelcomeButtonAction(getContext())
                        .setText("Contactar!")
                        .setTextColor(Color.WHITE)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("http://www.munirimac.gob.pe/portal/turismo-2/");
                            }
                        }))
                .endConfig()
                .build();

        mListView.getAdapter().add(card);
        mListView.getAdapter().add(card2);
        return v;
    }

    public void callPhoneNumber()
    {
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling

                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 101);


                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "0377778888"));
                startActivity(callIntent);

            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "0377778888"));
                startActivity(callIntent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 101)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhoneNumber();
            }
            else
            {

            }
        }
    }

}
