package com.coditec.virtualrimac.Utils;

/**
 * Created by USUARIO on 25/06/2018.
 */

public class CardItem {
    private int mTextResource;
    private int mTitleResource;

    public CardItem(int title, int text) {
        mTitleResource = title;
        mTextResource = text;
    }

    public int getText() {
        return mTextResource;
    }

    public int getTitle() {
        return mTitleResource;
    }
}
