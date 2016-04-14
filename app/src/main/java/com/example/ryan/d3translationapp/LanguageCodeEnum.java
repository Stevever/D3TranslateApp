package com.example.ryan.d3translationapp;

/**
 * File Created by Joseph on 4/12/16.
 *
 * This is an enumeration that maps the 3 letter language codes to readable language names.
 * Example: "English" = "eng", "Spanish" = "spa", etc
 *
 *
 * Update: It was an enumeration, but not anymore...
 */
public class LanguageCodeEnum {

    public LanguageCodeEnum()
    {

    }

    public static String getFullLang(String lang){
        switch (lang) {
            case "eng":
                return "English";
            case "spa":
                return "Spanish";
            case "deu":
                return "German";
            case "fra":
                return "French";
            case "cmn":
                return "Chinese (Mandarin)";
            case "jpn":
                return "Japanese";
            case "rus":
                return "Russian";
            case "ita":
                return "Italian";
            case "pol":
                return "Polish";
            default:
                return "Unknown Language";
        }

    }

    public static String getISO(String lang) {
        switch (lang) {
            case "English":
                return "eng";
            case "Spanish":
                return "spa";
            case "German":
                return "deu";
            case "French":
                return "fra";
            case "Chinese (Mandarin)":
                return "cmn";
            case "Japanese":
                return "jpn";
            case "Russian":
                return "rus";
            case "Italian":
                return "ita";
            case "Polish":
                return "pol";
            default:
                return "Unknown Language";
        }
    }
}
