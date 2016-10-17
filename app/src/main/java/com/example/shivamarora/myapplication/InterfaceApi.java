package com.example.shivamarora.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
public interface InterfaceApi {

    //compile==>           https://ideas2it-hackerearth.p.mashape.com/compile/
    //Run == >             https://ideas2it-hackerearth.p.mashape.com/run/


    @Headers({
            "X-Mashape-Key:kTqTHm4uBMmshfmDdxurmo37bdQlp11Th8CjsnZubdNWto0Ksf",
            "Content-Type : application/x-www-form-urlencoded" ,
            "Accept : application/json"
    })
    @FormUrlEncoded
    @POST("/compile/")
    Call<CompileResponse>  getDataForCompile(@Field("client_secret") String clientSecret , @Field("lang") String language , @Field("source") String sourceCode );





    @Headers({
            "X-Mashape-Key:kTqTHm4uBMmshfmDdxurmo37bdQlp11Th8CjsnZubdNWto0Ksf",
            "Content-Type : application/x-www-form-urlencoded" ,
            "Accept : application/json"
    })
    @FormUrlEncoded
    @POST("/run/")
    Call<RunResponse>  getDataForRun(@Field("client_secret") String clientSecret , @Field("lang") String language ,
                                     @Field("source") String sourceCode , @Field("input") String inputValue  );








}
