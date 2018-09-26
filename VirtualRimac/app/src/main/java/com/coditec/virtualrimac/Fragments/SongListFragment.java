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

public class SongListFragment extends Fragment{

    private Context mContext;
    private MaterialListView mListView;

    public SongListFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_place_list, container, false);
        // Save a reference to the
        //mContext = this;

        mListView = (MaterialListView) view.findViewById(R.id.lvPlace);

        mContext = getContext();



        Card can1 = new Card.Builder(getContext())

                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setDescription("Barrio Bajopontino\n"+"Autor: Luciano Huambachano")
                 .setDrawable(R.drawable.ca1)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("Escuchar")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card can1) {
                                Comunicacion.getInstance(mContext).ubicar("https://www.youtube.com/watch?v=TWpz-7bMHfc");
                            }
                        }))

                .endConfig()
                .build();


        Card can2 = new Card.Builder(getContext())

                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setDescription("Mi compadre Nicolas\n"+"Autor: Pepe Vásquez")
                .setDrawable(R.drawable.ca2)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("Escuchar")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card can2) {
                                Comunicacion.getInstance(mContext).ubicar("https://www.youtube.com/watch?v=CkMyxRDjHgY");
                            }
                        }))

                .endConfig()
                .build();



        Card can3 = new Card.Builder(getContext())

                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitleResourceColor(R.color.colorWhite)
                .setTitleGravity(Gravity.TOP)
                .setDescription("La flor de la canela\n"+"Autor: Chabuca Granda")
                .setDrawable(R.drawable.can3)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("Escuchar")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card can3) {
                                Comunicacion.getInstance(mContext).ubicar("https://www.youtube.com/watch?v=7APcNwhssXU");
                            }
                        }))

                .endConfig()
                .build();

        Card can4 = new Card.Builder(getContext())

                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setDescription("Rimac es otra historia\n"+"Autor: Guillermo Rivas")
                .setDrawable(R.drawable.can4)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("Escuchar")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card can3) {
                                Comunicacion.getInstance(mContext).ubicar("https://www.youtube.com/watch?v=riQ00bQgnvI");
                            }
                        }))

                .endConfig()
                .build();

        Card can5 = new Card.Builder(getContext())

                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setDescription("Jose Antonio\n"+"Autor: Chabuca granda")
                .setDrawable(R.drawable.can5)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("Escuchar")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card can3) {
                                Comunicacion.getInstance(mContext).ubicar("https://www.youtube.com/watch?v=ux2GAsSQ2WQ");
                            }
                        }))

                .endConfig()
                .build();


        mListView.getAdapter().add(can1);
        mListView.getAdapter().add(can2);
        mListView.getAdapter().add(can3);
        mListView.getAdapter().add(can4);
        mListView.getAdapter().add(can5);


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
