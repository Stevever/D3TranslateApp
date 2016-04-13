package com.example.ryan.d3translationapp;

/**
 * File Created by Joseph on 4/12/16.
 *
 * This is an enumeration that maps the 3 letter language codes to readable language names.
 * Example: "English" = "eng", "Spanish" = "spa", etc
 *
 */
public class LanguageCodeEnum {

    public enum Language {
        eng, spa, deu, fra, cmn, jpn, rus, ita, pol
    }

    Language lang;

    public LanguageCodeEnum(Language inlang){
        this.lang = inlang;
    }

    public String getFullLang(){
        switch (lang) {
            case eng:
                return "English";
            case spa:
                return "Spanish";
            case deu:
                return "German";
            case fra:
                return "French";
            case cmn:
                return "Chinese (Mandarin)";
            case jpn:
                return "Japanese";
            case rus:
                return "Russian";
            case ita:
                return "Italian";
            case pol:
                return "Polish";
            default:
                return "Unknown Language";

        }

    }
}
