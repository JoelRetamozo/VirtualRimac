package com.coditec.virtualrimac.Utils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coditec.virtualrimac.R;

/**
 * Created by USUARIO on 25/06/2018.
 */

public class CardFragment extends Fragment {

    private CardView cardView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_viewpager, container, false);
        cardView = v.findViewById(R.id.cardVieew);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        return v;
    }

    public CardView getCardView() {
        return cardView;
    }
}
