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
    TextView toLangText, fromLangText, phraseText, meaningText1;

    public DictionaryLookupActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView =  inflater.inflate(R.layout.fragment_dictionary_lookup, container, false);
        toLangText = (TextView) myView.findViewById(R.id.toLang);
        fromLangText = (TextView) myView.findViewById(R.id.fromLang);
        phraseText = (TextView) myView.findViewById(R.id.phrase);
        meaningText1 = (TextView) myView.findViewById(R.id.meaning1);
        Intent intent = getActivity().getIntent();

        String jsonString = intent.getStringExtra("JSONObject");
        //TODO Finish language code Enum
        //LanguageCodeEnum destLanguage = new LanguageCodeEnum(LanguageCodeEnum.Language.fromLang);

        String out = "error";
        try {
            JSONObject response = new JSONObject(jsonString);
            JSONResponseParser parser = new JSONResponseParser(response);
            String[] translations = parser.getTranslations();

            toLangText.setText("\tTo: " + parser.getToLang());
            fromLangText.setText("\tFrom: " + parser.getFromLang());
            phraseText.setText(parser.getPhrase());
            meaningText1.setText(translations[0]);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return myView;
    }
}
