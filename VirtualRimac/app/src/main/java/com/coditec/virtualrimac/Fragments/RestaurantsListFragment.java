package com.coditec.virtualrimac.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coditec.virtualrimac.Utils.Comunicacion;
import com.coditec.virtualrimac.R;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.listeners.RecyclerItemClickListener;
import com.dexafree.materialList.view.MaterialListView;


/**
 * Created by PC USER on 22/05/2018.
 */

public class RestaurantsListFragment extends Fragment{

    private Context mContext;
    private MaterialListView mListView;

    public RestaurantsListFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_restaurant_list, container, false);
        // Save a reference to the context
        //mContext = this;

        mListView = (MaterialListView) view.findViewById(R.id.lvPlace);

        mContext = getContext();

        Card res1 = new Card.Builder(getContext())
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("PURITO RIMAC")
                .setTitleResourceColor(R.color.colorWhite)
                .setTitleGravity(Gravity.TOP)
                .setDescription("Restaurante muy reconocido en el rimac por su variedad de platillos criollos.\n"+"Direccion: Jirón Libertad 184, Cercado de Lima 15093")
                .setDrawable(R.drawable.re1)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("IR AL LUGAR")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-12.1317221,-76.9795585?q=-12.1317221,-76.9795585(Facultad de Ingeniería URP");
                            }
                        }))

                .endConfig()
                .build();


        Card res2 = new Card.Builder(getContext())
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("LA COCINA DEL VIRREY ")
                .setTitleResourceColor(R.color.colorWhite)
                .setTitleGravity(Gravity.TOP)
                .setDescription("Muy buen lugar con estacionamiento y muy ricos platos criollos y marinos\n"+"Direccion: Atahualpa 145, Rímac 15093")
                .setDrawable(R.drawable.re2)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("IR AL LUGAR")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card res2) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-12.0375574,-77.0293127?q=-12.0375574,-77.0293127 (La Cocina del Virrey");
                            }
                        }))

                .endConfig()
                .build();





        mListView.getAdapter().add(res1);
        mListView.getAdapter().add(res2);



        // Add the ItemTouchListener
        mListView.addOnItemTouchListener(new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Card card, int position) {
                if(position == 0){

                }else if(position == 1){

                }else if(position == 2){

                }

                Log.d("CARD_TYPE", "" + card.getTag());
            }

            @Override
            public void onItemLongClick(@NonNull Card card, int position) {
                Log.d("LONG_CLICK", "" + card.getTag());
            }
        });
        return  view;
    }
}