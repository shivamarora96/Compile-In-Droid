package com.example.shivamarora.myapplication;

import java.util.HashMap;

public class Constants {


    static  final String baseUrl = "https://ideas2it-hackerearth.p.mashape.com";
    static final String clientSecret = "da09349886c6ac0f06349188adac25229d5aeef2" ;
    static HashMap<String , String> languageHaspMap ;

    //lang argument are C, CPP, CPP11, CLOJURE, CSHARP, JAVA, JAVASCRIPT, HASKELL, PERL, PHP, PYTHON, RUBY. The correspondi


    public static void setValuesToLanguageHaspMap() {
        languageHaspMap = new HashMap<>() ;
        languageHaspMap.put("CPP" , "CPP11" );
        languageHaspMap.put("CLOJURE" , "CLOJURE" );
        languageHaspMap.put("CSHARP" , "CSHARP" );
        languageHaspMap.put("JAVA" , "JAVA" );
        languageHaspMap.put("JAVASCRIPT" , "JAVASCRIPT" );
        languageHaspMap.put("HASKELL" , "HASKELL" );
        languageHaspMap.put("PERL" , "PERL" );
        languageHaspMap.put("PHP" , "PHP" );
        languageHaspMap.put("PYTHON" , "PYTHON" );
        languageHaspMap.put("RUBY" , "RUBY" );
    }

}
