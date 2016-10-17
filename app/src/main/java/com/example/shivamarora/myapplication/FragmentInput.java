package com.example.shivamarora.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentInput extends Fragment {

    EditText input ;
    Button input_button ;
   static ClickListnerInput mClickListner ;

    public interface ClickListnerInput{
        void OnButtonInputClicked(String s) ;
    }


   static void setClickListner(ClickListnerInput clickListner){
        FragmentInput.mClickListner = clickListner;
    }


    public FragmentInput() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment_input, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        input = (EditText)view.findViewById(R.id.input_edittext);
        input_button = (Button)view.findViewById(R.id.inputButton) ;
        input_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(mClickListner != null)
                {   mClickListner.OnButtonInputClicked(input.getText().toString());
                    Toast.makeText(FragmentInput.this.getActivity() , "Input button CLicked" , Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(FragmentInput.this.getActivity() , "Empty Listner" , Toast.LENGTH_SHORT).show();

            }
        });


         }
}
