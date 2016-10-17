package com.example.shivamarora.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements FragmentSource.ClickListnerSource , FragmentInput.ClickListnerInput {

    DrawerLayout drawerLayout ;
    NavigationView navigationView ;

    String mClientSecret ;
    String mLanguage   ;
    String mBaseUrl  ;
    String mSourceCode;
    String mInput;
    String mOutput;

    TabLayout mTablayout ;
    ViewPagerAdapter viewPagerAdapter ;
    ViewPager viewPager ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView = (NavigationView)findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this ,drawerLayout , R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mClientSecret = Constants.clientSecret ;
        mLanguage  =  "CPP" ;
        mBaseUrl = Constants.baseUrl ;
        mSourceCode = "";
        mInput = "" ;



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.c) {
                    mLanguage = "C";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "C" , Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.java) {
                    mLanguage = "JAVA";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "JAVA" , Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.cpp) {
                    mLanguage = "CPP";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "C ++ " , Toast.LENGTH_SHORT).show();
                }
                else if (itemId == R.id.python) {
                    mLanguage = "PYTHON";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "PYTHON " , Toast.LENGTH_SHORT).show();
                }
                else if (itemId == R.id.ruby) {
                    mLanguage = "RUBY";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "RUBY " , Toast.LENGTH_SHORT).show();
                }

                else if (itemId == R.id.js) {
                    mLanguage = "JAVASCRIPT";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "JAVASCRIPT " , Toast.LENGTH_SHORT).show();
                }
               /* else if (itemId == R.id.php) {
                    mLanguage = "PHP";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "PHP " , Toast.LENGTH_SHORT).show();
                }*/
                else if (itemId == R.id.clojure) {
                    mLanguage = "CLOJURE";
                    drawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext() , "CLOJURE " , Toast.LENGTH_SHORT).show();
                }
                else if(itemId == R.id.refer)
                {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Here is the share content body";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }
                else if(itemId == R.id.exit){
                    MainActivity.this.finish();
                }
                return true ;
            }
        });




        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        mTablayout.setupWithViewPager(viewPager);
        FragmentSource.setClickListnerSource(MainActivity.this);
        FragmentInput.setClickListner(MainActivity.this);
    }

    public void setmSourceCode(String mSourceCode) {

        MainActivity.this.mSourceCode = mSourceCode ;
        Log.i("mSource" ,mSourceCode);
    }
    public void setmInput(String input) {

        MainActivity.this.mInput = input ;
        Log.i("minput" ,mInput);
    }

    private void compileAndRun(String baseUrl,  final String clientSecret,  final String language , final String sourceCode , final String inputCode) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
        final InterfaceApi interfaceService = retrofit.create(InterfaceApi.class);

//        Constants.setValuesToLanguageHaspMap();

        Call<CompileResponse> callCompile = interfaceService.getDataForCompile(clientSecret, language, sourceCode);
        callCompile.enqueue(new Callback<CompileResponse>() {
            @Override
            public void onResponse(Call<CompileResponse> call, Response<CompileResponse> response) {
                   String compileStatus = response.body().getCompile_status();
                   Toast.makeText(MainActivity.this, compileStatus + "Compiled ", Toast.LENGTH_LONG).show();
                    runCode(clientSecret, language, interfaceService, sourceCode, inputCode);
                    }


            @Override
            public void onFailure(Call<CompileResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Compile Response is not Successfull", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void runCode(String clientSecret, String language, InterfaceApi interfaceService , String sourceCode , String inputCode) {
        Call<RunResponse> callrun = interfaceService.getDataForRun(clientSecret, language
                , sourceCode , inputCode );

        callrun.enqueue(new Callback<RunResponse>() {
            @Override
            public void onResponse(Call<RunResponse> call, Response<RunResponse> response) {

               mOutput = response.body().getData().getOutput();
                Log.i("output" , mOutput);
                Toast.makeText(MainActivity.this, response.body().getCompile_status() + "Running... ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RunResponse> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Running Response is not Successfull", Toast.LENGTH_LONG).show();
                }

        });
    }

    @Override
    public void OnButtonSourceClicked(String s) {
                setmSourceCode(s);
    }

    @Override
    public void OnButtonInputClicked(String s) {
        setmInput(s);
        compileAndRun(mBaseUrl, mClientSecret, mLanguage, mSourceCode, mInput);

        FragmentOutput.setmOutputEdittext(MainActivity.this.mOutput);


    }
}
