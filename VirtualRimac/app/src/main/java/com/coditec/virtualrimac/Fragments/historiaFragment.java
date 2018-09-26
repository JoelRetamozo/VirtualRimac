package com.coditec.virtualrimac.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import com.coditec.virtualrimac.R;
import com.coditec.virtualrimac.Utils.CardItem;
import com.coditec.virtualrimac.Utils.CardPagerAdapter;
import com.coditec.virtualrimac.Utils.CardFragmentPagerAdapter;
import com.coditec.virtualrimac.Utils.ShadowTransformer;


/**
 * A simple {@link Fragment} subclass.
 */
public class historiaFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private CardPagerAdapter mCardAdapter;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ViewPager mViewPager;
   // private Button mButton;

    private ShadowTransformer mCardShadowTransformer;
    private ShadowTransformer mFragmentCardShadowTransformer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_historia, container, false);
        mViewPager = v.findViewById(R.id.viewPager);
        //mButton = (Button) v.findViewById(R.id.cardTypeBtn);
        //((CheckBox) findViewById(R.id.checkBox)).setOnCheckedChangeListener(this);
//        mButton.setOnClickListener(this);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.texto));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.texto2));
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.texto3));

        mFragmentCardAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(), dpToPixels(2, getContext()));
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mCardShadowTransformer.enableScaling(true);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        return v;
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}
