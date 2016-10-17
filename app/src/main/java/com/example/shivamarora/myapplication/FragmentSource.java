package com.example.shivamarora.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentSource extends Fragment {

    EditText source ;
    Button sourceButton ;

   static ClickListnerSource mClickListner ;


    public interface ClickListnerSource {
        void OnButtonSourceClicked(String s) ;
    }

   static void setClickListnerSource( ClickListnerSource clickListner){
        mClickListner = clickListner ;
    }


    public FragmentSource() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment_source , container , false);
         }

    @Override
    public void
    onViewCreated(View view, Bundle savedInstanceState) {
        source = (EditText)view.findViewById(R.id.sourceCode);
        sourceButton = (Button)view.findViewById(R.id.sorceButton) ;



        sourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mClickListner!=null){

                    String currentSource = source.getText().toString() ;
                    mClickListner.OnButtonSourceClicked(currentSource);
                    Toast.makeText(FragmentSource.this.getActivity() , "Button Clicked !!" , Toast.LENGTH_SHORT ).show();

                }

                else if(mClickListner == null) {
                    Toast.makeText(FragmentSource.this.getActivity(), "Listner is null", Toast.LENGTH_SHORT).show();
                }

                }
        });


    }





}
