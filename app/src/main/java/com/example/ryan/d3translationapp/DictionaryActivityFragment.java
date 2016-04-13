package com.example.ryan.d3translationapp;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class DictionaryActivityFragment extends Fragment {
	Button button;
	TextView textView;

	public DictionaryActivityFragment() {
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View myView = inflater.inflate(R.layout.fragment_dictionary, container, false);
		button = (Button) myView.findViewById(R.id.button);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				beginLookup(view);
			}
		});

		textView = (TextView) myView.findViewById(R.id.toTranslate);
		return myView;
	}

	private void beginLookup(View view){
		String fromLang = "eng";
		String toLang = "spa";
		String phrase = textView.getText().toString();
		new DictionaryLookupTask(getContext()).execute(fromLang, toLang, phrase);
	}

}
