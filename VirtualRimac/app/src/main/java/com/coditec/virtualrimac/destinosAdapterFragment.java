package com.coditec.virtualrimac;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coditec.virtualrimac.Utils.Comunicacion;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.view.MaterialListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class destinosAdapterFragment extends Fragment {

    private Context mContext;
    private MaterialListView mListView;

    public destinosAdapterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_destinos_adapter, container, false);

        mListView = view.findViewById(R.id.lvDestinosadapter);

        mContext = getContext();

        Card res1 = new Card.Builder(getContext())
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle("Museo Naval Casa Grau")
                .setTitleResourceColor(R.color.colorWhite)
                .setTitleGravity(Gravity.TOP)
                .setDescription("El museo que corresponde a la casa donde vivió Miguel Grau expone mobiliario, fotografías, mapas y documentos del héroe naval")
                .setDrawable(R.drawable.naval)
                .addAction(R.id.left_text_button, new TextViewAction(mContext)
                        .setText("IR AL LUGAR")
                        .setTextResourceColor(R.color.colorPrimary)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Comunicacion.getInstance(mContext).ubicar("geo:-12.047648,-77.033225?q=-12.1317221,-76.9795585(Museo Naval)");
                            }
                        }))

                .endConfig()
                .build();

        mListView.getAdapter().add(res1);

        return view;
    }



}
