package com.example.ryan.d3translationapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.IOException;

/**
 * File Created by Joseph on 4/12/16.
 */
public class DictionaryLookupTask extends AsyncTask<String, Void, JSONObject> {

    Context context;
    Intent intent;

    public DictionaryLookupTask(Context context){
        this.context = context.getApplicationContext();
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(String... params){
        DictionaryLookup lookup = new DictionaryLookup(params[0], params[1], params[2]);
        intent = new Intent(context, DictionaryLookupActivity.class);
        intent.putExtra("fromLang", params[0]);
        intent.putExtra("toLang", params[1]);
        intent.putExtra("phrase", params[2]);
        try {
            return lookup.getLookUpData();
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    @Override
    protected void onPostExecute(JSONObject result){
        //Intent intent = new Intent(context, DictionaryLookupActivity.class);
        intent.putExtra("JSONObject", result.toString());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }




}
