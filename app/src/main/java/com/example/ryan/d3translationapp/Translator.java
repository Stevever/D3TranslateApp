package com.example.ryan.d3translationapp;

/**
 * Created by ryan on 4/6/16.
 *
 * Translator class. Connects to internet and returns given text.
 */
public final class Translator {
	private static UserPreferences.Language sTargetLanguage;
	private static Translator sTranslator;

	private Translator() {
		// empty constructor
	}

	private Translator getInstance() {
		if (sTranslator == null) {
			sTranslator = new Translator();
			sTargetLanguage = UserPreferences.getTargetLanguage();
		}

		return sTranslator;
	}

	public static UserPreferences.Language getTargetLanguage() {
		return sTargetLanguage;
	}

	/**
	 * Translates text to whatever the target language is set to.
	 * @param string
	 * @return
	 */
	public static String translate(String string) {
		// TODO: implement
		return "";
	}
}
