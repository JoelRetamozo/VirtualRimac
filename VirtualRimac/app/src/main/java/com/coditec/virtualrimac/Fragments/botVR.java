package com.coditec.virtualrimac.Fragments;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.coditec.virtualrimac.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class botVR extends Fragment {

    Button btnVR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bot_vr, container, false);

        btnVR = v.findViewById(R.id.btnBot);

        btnVR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMessnger();
            }
        });

        return v;
    }

    public void openMessnger()
    {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/" + "130704127710614"));

        try
        {
            startActivity(intent);
        }
        catch (ActivityNotFoundException ex)
        {
            Toast.makeText(getContext(),
                    "Oups!Can't open Facebook messenger right now. Please try again later.",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
