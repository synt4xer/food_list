package com.syntaxer.mysubmission.custom;

import android.view.View;

/**
 * Created by Android Studio.
 * User: FERREL JOHN FERNANDO
 * Date: 12/06/2019.
 * Time: 16:01.
 * To change this template use File | Settings | File and Code Templates.
 */
public class CustomOnItemClickListener implements View.OnClickListener {
    private int i;
    private OnItemClickCallBack onItemClickCallBack;

    public CustomOnItemClickListener(int i, OnItemClickCallBack onItemClickCallBack) {
        this.i = i;
        this.onItemClickCallBack = onItemClickCallBack;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallBack.onItemClicked(view, i);
    }

    public interface OnItemClickCallBack {
        void onItemClicked(View view, int i);
    }
}
