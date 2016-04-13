package com.example.ryan.d3translationapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import com.neovisionaries.i18n.LanguageAlpha3Code;

/**
 * A placeholder fragment containing a simple view.
 */
public class DictionaryLookupActivityFragment extends Fragment {

    JSONObject jsonResult;
    TextView toLangText;

    public DictionaryLookupActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView =  inflater.inflate(R.layout.fragment_dictionary_lookup, container, false);
        toLangText = (TextView) myView.findViewById(R.id.fromLang);
        Intent intent = getActivity().getIntent();

        String jsonString = intent.getStringExtra("JSONObject");
        String fromLang = intent.getStringExtra("fromLang");
        //TODO Finish language code Enum
        //LanguageCodeEnum destLanguage = new LanguageCodeEnum(LanguageCodeEnum.Language.fromLang);

        String out = "error";
        try {
            JSONObject jsonResult = new JSONObject(jsonString);
            JSONArray tuc = jsonResult.getJSONArray("tuc");
            JSONObject zero = tuc.getJSONObject(0);
            JSONObject phrase = zero.getJSONObject("phrase");
            out = phrase.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        toLangText.setText(out);
        return myView;
    }
}
