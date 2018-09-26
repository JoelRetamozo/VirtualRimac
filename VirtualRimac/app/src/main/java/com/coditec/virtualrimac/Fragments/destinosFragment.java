package com.coditec.virtualrimac.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coditec.virtualrimac.R;
import com.coditec.virtualrimac.destinosAdapterFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class destinosFragment extends Fragment {

    CardView btnDestinos;


    public destinosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_destinos, container, false);

        btnDestinos = v.findViewById(R.id.btnMuseosDestinos);

        btnDestinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFramento(new destinosAdapterFragment());
            }
        });


        return v;
    }

    private void cargarFramento(Fragment fragment){
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.containerFrag,fragment).addToBackStack(null).commit();
    }

}
