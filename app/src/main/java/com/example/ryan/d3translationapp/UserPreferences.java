package com.example.ryan.d3translationapp;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by ryan on 4/6/16.
 *
 * UserPreferences is a class that just stores all the preferences with regards to the user.
 */
public final class UserPreferences {
	private static Language sTargetLanguage;
	private static String sName;

	private final static String LANGUAGE_KEYWORD = "language";
	private final static String USERNAME_KEYWORD = "username";


	private UserPreferences() {
		// empty constructor
	}

	/**
	 * Enumeration outlining supported languages.
	 */
	public enum Language {
		SPANISH, PORTUGUESE, GERMAN
	}

	public static String getName() {
		return sName;
	}

	public static void setName(String name) {
		sName = name;
	}

	public static void setTargetLanguage(String language) {
		sTargetLanguage = Language.valueOf(language.toUpperCase());
	}

	public static Language getTargetLanguage() {
		return sTargetLanguage;
	}

	/**
	 * Saves current user preferences to device storage
	 * @param activity current activity
	 */
	public static void savePreferences(Activity activity) {
		final String PREFS_FILE_NAME = "D3TranslatePrefs";

		SharedPreferences settings = activity.getSharedPreferences(PREFS_FILE_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString(LANGUAGE_KEYWORD, sTargetLanguage.toString());
		editor.putString(USERNAME_KEYWORD, sName);
		editor.apply();
	}

	/**
	 * Loads user preferences to device storage
	 * @param activity current activity
	 */
	public static void loadPreferences(Activity activity) {
		final String PREFS_FILE_NAME = "D3TranslatePrefs";

		SharedPreferences settings = activity.getSharedPreferences(PREFS_FILE_NAME, 0);

		setTargetLanguage(settings.getString(LANGUAGE_KEYWORD, null));
		setName(settings.getString(USERNAME_KEYWORD, null));
	}

}
