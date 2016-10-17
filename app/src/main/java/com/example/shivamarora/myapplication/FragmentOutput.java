package com.example.shivamarora.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FragmentOutput extends Fragment {

 static private EditText mOutputEdittext ;

    public FragmentOutput() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View c =inflater.inflate(R.layout.fragment_fragment_output, container, false);
        mOutputEdittext = (EditText)c.findViewById(R.id.outputEditText);
        return  c;
    }


    static public void setmOutputEdittext(String s) {
       FragmentOutput.mOutputEdittext.setText(s);
    }
}
