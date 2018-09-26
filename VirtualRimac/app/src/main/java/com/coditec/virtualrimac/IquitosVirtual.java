package com.coditec.virtualrimac;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.coditec.virtualrimac.Fragments.VRfragment;
import com.coditec.virtualrimac.Utils.Comunicacion;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.listeners.RecyclerItemClickListener;
import com.dexafree.materialList.view.MaterialListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IquitosVirtual extends Fragment {

    private Context mContext;
    private MaterialListView mListView;

    android.support.v7.widget.Toolbar xx;

    public IquitosVirtual() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_iquitos_virtual, container, false);

        mListView = (MaterialListView) view.findViewById(R.id.lvPlaceIquitos);
/*
        xx = (android.support.v7.widget.Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getContext()).setSupportActionBar(xx);
        ((AppCompatActivity)getContext()).getSupportActionBar().setTitle("Iquitos Virtual");
*/

        mContext = getContext();

        Card card = new Card.Builder(getContext())
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("Iquitos - Rio Amazonas")
                .setTitleResourceColor(R.color.colorWhite)
                .setTitleGravity(Gravity.TOP)

                .setDescription("El río Amazonas es un río de América del Sur, que atraviesa Perú, Colombia y Brasil. Es el río más largo y caudaloso del mundo.")
                .setDrawable(R.drawable.iqui)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("Google Maps")
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-3.765011,-73.319531?q=-3.765011,-73.319531(Rio Amazonas)");
                            }
                        }))
                .addAction(R.id.right_text_button, new TextViewAction(getContext())
                        .setText("Realidad Virtual")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                goToFragment("iquitos.jpg");
                            }
                        }))
                .endConfig()
                .build();

        Card[] cartas = {card};


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


        return view;
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
