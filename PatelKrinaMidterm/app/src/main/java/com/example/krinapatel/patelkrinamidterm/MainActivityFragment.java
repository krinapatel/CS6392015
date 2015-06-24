package com.example.krinapatel.patelkrinamidterm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public EditText et1, et2;
    public Button button;
    private double val,dollar,result;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        et1 = (EditText) rootView.findViewById(R.id.editText);
        et2 = (EditText) rootView.findViewById(R.id.editText2);
        button = (Button) rootView.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              val = 586.84;
                String input = et1.getText().toString();
                try
                {
                    dollar = Double.valueOf(input);

                    result = Double.parseDouble(et1.getText().toString()) * val;
                    String res = Double.toString(result);
                    et2.setText(res);
                }
                catch(NumberFormatException nfe)
                {
                    nfe.printStackTrace();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        return rootView;
    }




}
