package com.example.ryan.d3translationapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class DictionaryActivityFragment extends Fragment implements AdapterView.OnItemSelectedListener{
	Button button;
	TextView textView;
	Spinner fromSpinner;
	Spinner toSpinner;
	String fromLang;
	String toLang;

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

		fromSpinner = (Spinner) myView.findViewById(R.id.spinnerFrom);
		toSpinner = (Spinner) myView.findViewById(R.id.spinnerTo);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
				R.array.dictionary_choices, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fromSpinner.setAdapter(adapter);
		fromSpinner.setOnItemSelectedListener(this);
		toSpinner.setAdapter(adapter);
		toSpinner.setOnItemSelectedListener(this);

		return myView;
	}

	private void beginLookup(View view){
		String phrase = textView.getText().toString();
		new DictionaryLookupTask(getContext()).execute(fromLang, toLang, phrase);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

		switch (parent.getId()){
			case R.id.spinnerFrom:
				fromLang = LanguageCodeEnum.getISO((String) parent.getItemAtPosition(position));
				break;
			default:
				toLang = LanguageCodeEnum.getISO((String) parent.getItemAtPosition(position));
				break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		//Nothing yet
	}
}
