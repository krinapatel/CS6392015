package com.example.krinapatel.imageviewer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
{
    private static ImageView imgView;
    private static Button b1, b2;
    private static TextView t1;

    private int current_image_index=0;

    int[] images = {R.drawable.englishbulldog,
            R.drawable.germanshepherd,
            R.drawable.goldenretriever,
            R.drawable.hsukymix,
            R.drawable.yorkshireterrier};

    String[] names = {"English Bulldog",
            "German Shepherd",
            "Golden Retriever",
            "Hsuky Mix",
            "Yorkshire Terrier"};

    public MainActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        imgView = (ImageView) rootView.findViewById(R.id.imageView);
        b1 = (Button) rootView.findViewById(R.id.prevbtn);
        b2 = (Button) rootView.findViewById(R.id.nextbtn);
        t1 = (TextView) rootView.findViewById(R.id.txtview);

        b1.setOnClickListener(prevButtonChangeImageListener);
        b2.setOnClickListener(nextButtonChangeImageListener);

        return rootView;
    }

    View.OnClickListener prevButtonChangeImageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            try
            {
                current_image_index++;
                current_image_index = current_image_index % images.length;
                imgView.setImageResource(images[current_image_index]);
                t1.setText(names[current_image_index]);
            }
            catch(Exception e)
            {
            }
        }
    };

    View.OnClickListener nextButtonChangeImageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            try
            {
                current_image_index--;
                current_image_index = (current_image_index + images.length) % images.length;
                imgView.setImageResource(images[current_image_index]);
                t1.setText(names[current_image_index]);
            }
            catch(Exception e)
            {
            }
        }
    };

}
