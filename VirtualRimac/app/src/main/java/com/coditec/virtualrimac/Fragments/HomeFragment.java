package com.coditec.virtualrimac.Fragments;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.coditec.virtualrimac.R;


public class HomeFragment extends Fragment {

    private CardView cvRutas, cvDestinos, cvGastro, cvTours, cvCanciones, cvHistoria;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cvRutas = view.findViewById(R.id.btnRutas);
        cvDestinos = view.findViewById(R.id.btnDestinos);
        cvGastro = view.findViewById(R.id.btnGastronomia);
        cvTours = view.findViewById(R.id.btnTours);
        cvCanciones = view.findViewById(R.id.btnCanciones);
        cvHistoria = view.findViewById(R.id.btnHistoria);

        cvRutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFramento(new PlaceListFragment());
            }
        });

        cvGastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFramento(new RestaurantsListFragment());
            }
        });

        cvCanciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFramento(new SongListFragment());
            }
        });

        cvTours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFramento(new ToursFragment());
            }
        });

        cvHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFramento(new historiaFragment());
            }
        });

        cvDestinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarFramento(new destinosFragment());
            }
        });

        return view;
    }

    private void cargarFramento(Fragment fragment){
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.containerFrag,fragment).addToBackStack(null).commit();
    }





}
