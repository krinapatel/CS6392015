package com.example.krinapatel.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import org.apache.http.HttpConnection;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final Button b1;
        int i=0;
       // super.onCreate(savedInstanceState);

        ImageDownloader id = new ImageDownloader();

        id.execute("https://raw.githubusercontent.com/krinapatel/CS6392015/master/Bhuj_City.jpg");

        b1 = (Button) rootView.findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener()
        {
            int i=0;

            @Override
            public void onClick(View v)
            {
                ImageDownloader id1 = new ImageDownloader();
                if(i==0)
                {
                    id1.execute("https://raw.githubusercontent.com/krinapatel/CS6392015/master/Kutch_Rann.jpg");
                    b1.setText("KUTCH RANN UTSAV");
                    i++;
                }
                else if(i==1)
                {
                    id1.execute("https://raw.githubusercontent.com/krinapatel/CS6392015/master/Bhuj_City.jpg");
                    b1.setText("BHUJ CITY");
                    i--;
                }
            }
        });

        return rootView;
    }

    private class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

                if (httpCon.getResponseCode() != 200)
                    throw new Exception("Failed to Connect");

                InputStream is = httpCon.getInputStream();
                return BitmapFactory.decodeStream(is);
            } catch (Exception e) {
                Log.e("Image", "Failed to load image", e);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... params) {
            //Update a progress bar here, or ignore it, it's up to you
        }

        @Override
        protected void onPostExecute(Bitmap img) {
            ImageView iv = (ImageView) getView().findViewById(R.id.imageView);

            if (iv != null && img != null) {
                iv.setImageBitmap(img);
            }
        }

        @Override
        protected void onCancelled() {
            //
        }
    }
}