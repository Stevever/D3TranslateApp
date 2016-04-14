package com.example.ryan.d3translationapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

/**
 * File Created by Joseph on 4/14/16.
 *
 * This class is used to parse the response item received when making a dictionary lookup
 */
public class JSONResponseParser {

    JSONObject response;

    public JSONResponseParser(JSONObject response) {
        this.response = response;
    }

    public String getToLang() throws JSONException{
        return response.getString("dest");
    }

    public String getFromLang() throws JSONException{
        return response.getString("from");
    }

    public String getPhrase() throws JSONException{
        return response.getString("phrase");
    }

    public String[] getTranslations() throws JSONException{
        String[] translations = new String[6];
        JSONArray tuc = response.getJSONArray("tuc");
        JSONObject meaning;
        for (int i = 0; ((i < tuc.length()) && (i < 6)); i++) {
            meaning = tuc.getJSONObject(i);
            meaning = meaning.getJSONObject("phrase");
            translations[i] = meaning.getString("text");
        }

        return translations;
    }
}
