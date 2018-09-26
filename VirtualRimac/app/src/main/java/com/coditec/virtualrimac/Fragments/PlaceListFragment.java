package com.coditec.virtualrimac.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coditec.virtualrimac.Utils.Comunicacion;
import com.coditec.virtualrimac.R;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.listeners.RecyclerItemClickListener;
import com.dexafree.materialList.view.MaterialListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceListFragment extends Fragment {

    private Context mContext;
    private MaterialListView mListView;

    public PlaceListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_place_list, container, false);
        // Save a reference to the context
        //mContext = this;

        mListView = (MaterialListView) view.findViewById(R.id.lvPlace);

        mContext = getContext();

        Card card = new Card.Builder(getContext())
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("Plaza de Acho")
                .setTitleResourceColor(R.color.colorWhite)
                .setTitleGravity(Gravity.TOP)

                .setDescription("La plaza de toros de Acho, coso taurino ubicado en Lima, Perú, " +
                        "es la segunda plaza de toros más grande del mundo, por detrás de la Maestranza " +
                        "de Sevilla, España")
                .setDrawable(R.drawable.acho)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("Google Maps")
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-12.1317221,-76.9795585?q=-12.1317221,-76.9795585(Facultad de Ingeniería URP)");
                            }
                        }))
                .addAction(R.id.right_text_button, new TextViewAction(getContext())
                        .setText("Realidad Virtual")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                goToFragment("plazatoros.JPG");
                            }
                        }))
                .endConfig()
                .build();

        Card card1 = new Card.Builder(mContext)
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("Alameda de los Descalzos")
                .setTitleResourceColor(R.color.colorWhite)
                .setDescription("Alameda de los Descalzos construida por el Virrey Marqués de Montesclaros, en 1610, con el " +
                        "objetivo de embellecer el camino que dirigía al Convento de los Descalzos y " +
                        "facilitar el camino de los devotos que frecuentaban la iglesia de los religiosos " +
                        "franciscanos")
                .setDrawable(R.drawable.descalzos)
                .addAction(R.id.left_text_button, new TextViewAction(getContext())
                        .setText("Google Maps")
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-12.1321276,-76.9796283?q=-12.1321276,-76.9796283(Facultad de Arquitectura URP)");
                            }
                        }))
                .addAction(R.id.right_text_button, new TextViewAction(getContext())
                        .setText("Realidad Virtual")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                goToFragment("paseodescalzos.JPG");
                            }
                        }))
                .endConfig()
                .build();



        Card card2 = new Card.Builder(mContext)
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("Quinta Presa")
                .setTitleResourceColor(R.color.colorWhite)
                .setDescription("La Quinta Presa es una residencia veraniega ubicada en las afueras " +
                        "del casco histórico de Lima. Debe su nombre a que su primera propietaria fue " +
                        "Isabel Carrillo de Albornoz y de la Presa.")
                .setDrawable(R.drawable.quinta_presa)
                .addAction(R.id.left_text_button, new TextViewAction(getContext())
                        .setText("Google Maps")
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-12.1333547,-76.9809625?q=-12.1333547,-76.9809625(Facultad de Medicina URP)");
                            }
                        }))
                .addAction(R.id.right_text_button, new TextViewAction(mContext)
                        .setText("Realidad Virtual°")
                        .setTextResourceColor(R.color.colorPrimary)
                       /*replace with gragmetn*/ .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                goToFragment("quintapresa.jpg");
                            }
                        }))
                .endConfig()
                .build();


        Card card3 = new Card.Builder(mContext)
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("Paseo de Aguas")
                .setTitleResourceColor(R.color.colorWhite)
                .setDescription("El Paseo de Aguas fue construido entre 1770 y 1776 por el virrey Manuel Amat y Juniet. En su cercanía se encuentra la plaza de toros de plaza de toros de Acho.")
                .setDrawable(R.drawable.pasoag)
                .addAction(R.id.left_text_button, new TextViewAction(getContext())
                        .setText("Google Maps")
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-12.1333547,-76.9809625?q=-12.1333547,-76.9809625(Facultad de Medicina URP)");
                            }
                        }))
                .addAction(R.id.right_text_button, new TextViewAction(mContext)
                        .setText("Realidad Virtual")
                        .setTextResourceColor(R.color.colorPrimary)
                       /*replace with gragmetn*/ .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                goToFragment("paseoaguas.JPG");
                            }
                        }))
                .endConfig()
                .build();


        Card[] cartas = {card, card3, card1, card2};


        for(int i = 0; i < cartas.length; i++) { mListView.getAdapter().add(cartas[i]);}

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

    public void goToFragment(String ur)
    {
        Bundle bundle = new Bundle();
        bundle.putString("urlVR",ur);
        VRfragment vRfragment = new VRfragment();
        vRfragment.setArguments(bundle);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.containerFrag, vRfragment).addToBackStack(null).commit();
    }

}
