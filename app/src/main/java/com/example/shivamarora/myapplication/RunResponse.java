package com.example.shivamarora.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ShivamArora on 09-07-2016.
 */
public class RunResponse {
    @SerializedName("run_status")
    Data data;

    @SerializedName("id")
    String id;

    @SerializedName("compile_status")
    String compile_status;

    @SerializedName("web_link")
    String Web_link;

    @SerializedName("code_id")
    String code_id;


    public String getCode_id() {
        return code_id;
    }

    public String getCompile_status() {
        return compile_status;
    }

    public Data getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public String getWeb_link() {
        return Web_link;
    }
}

class Data{

    String output;

    public String getOutput() {
        return output;
    }

}