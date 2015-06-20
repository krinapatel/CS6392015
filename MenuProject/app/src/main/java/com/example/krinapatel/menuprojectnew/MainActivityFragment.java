package com.example.krinapatel.menuprojectnew;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button b1,b2,b3,b4,b5,b6;
        b1 = (Button) rootView.findViewById(R.id.button1);
        b2 = (Button) rootView.findViewById(R.id.button2);
        b3 = (Button) rootView.findViewById(R.id.button3);
        b4 = (Button) rootView.findViewById(R.id.button4);
        b5 = (Button) rootView.findViewById(R.id.button5);
        b6 = (Button) rootView.findViewById(R.id.button6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("smsto:" + Uri.encode("+13478427256")));
                i.putExtra("sms_body", "Krina Patel");
                i.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+13478427256"));
                i.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com/index.html"));
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(String.format("geo:23.2500,69.6700?q=BHUJ")));
                startActivity(i);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Share the love");
                startActivity(i.createChooser(i, "Share the love"));
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), NewActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }
}
