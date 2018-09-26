package com.coditec.virtualrimac.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coditec.virtualrimac.R;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class VRfragment extends Fragment {

    private VrPanoramaView vr_pan_view;

    private String TAG = "VRfragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      final View view = inflater.inflate(R.layout.fragment_vrfragment, container, false);

      String productForImages = getArguments().getString("urlVR");

      String PhotoURL = "https://s3.amazonaws.com/virtualrimac/src/" + productForImages;

      new myVrTask(getContext(), view, PhotoURL).execute();

        return view;
    }

    public Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private class myVrTask extends AsyncTask <Void, Integer, Void>
    {
        Context context;
        View view;
        Bitmap bitmap;
        VrPanoramaView.Options options;
        ProgressDialog progressDialog;
        String URL;

        public myVrTask(Context c, View v, String url)
        {
            context = c;
            view = v;
            URL = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Descargando VR...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            try {
                vr_pan_view = (VrPanoramaView) view.findViewById(R.id.vr_pan_view);
                bitmap = getBitmapFromURL(URL);
                options = new VrPanoramaView.Options();
                options.inputType = VrPanoramaView.Options.TYPE_MONO;
                vr_pan_view.setEventListener(new VrPanoramaEventListener() {

                    @Override
                    public void onDisplayModeChanged(int newDisplayMode) {
                        super.onDisplayModeChanged(newDisplayMode);
                        Log.d(TAG, "onDisplayModeChanged()->newDisplayMode=" + newDisplayMode);
                    }

                    @Override
                    public void onLoadError(String errorMessage) {
                        super.onLoadError(errorMessage);
                        Log.d(TAG, "onLoadError()->errorMessage=" + errorMessage);
                    }

                    @Override
                    public void onLoadSuccess() {
                        super.onLoadSuccess();
                        Log.d(TAG, "onLoadSuccess");
                    }

                    @Override
                    public void onClick() {
                        super.onClick();
                        Log.d(TAG, "onClick()");
                    }
                });
            }catch (Exception e){}


            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.hide();
            vr_pan_view.loadImageFromBitmap(bitmap, options);
        }
    }




}
