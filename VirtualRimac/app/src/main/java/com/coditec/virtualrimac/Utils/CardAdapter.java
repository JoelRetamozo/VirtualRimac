package com.coditec.virtualrimac.Utils;

import android.support.v7.widget.CardView;

/**
 * Created by USUARIO on 25/06/2018.
 */

public interface CardAdapter {

    public final int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}