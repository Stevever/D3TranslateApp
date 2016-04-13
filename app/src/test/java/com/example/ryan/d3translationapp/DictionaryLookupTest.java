package com.example.ryan.d3translationapp;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * File Created by Joseph on 4/12/16.
 */
public class DictionaryLookupTest {

    @Test
    public void testUrlMakerGeneral() throws Exception {
        DictionaryLookup exampleLookUp = new DictionaryLookup("eng","pol","cat");
        //Lookup the Polish translation of "cat"
        String actualURL = exampleLookUp.urlMaker("eng","pol","cat");
        String expURL = "https://glosbe.com/gapi/translate?from=eng&dest=pol&format=json&phrase=cat";
        assertEquals(expURL, actualURL);
    }

    @Test
    public void testUrlMakerGeneral2() throws Exception {
        DictionaryLookup exampleLookUp = new DictionaryLookup("eng","spa","population");
        //Lookup the Spanish translation of "population"
        String actualURL = exampleLookUp.urlMaker("eng","spa","population");
        String expURL = "https://glosbe.com/gapi/translate?from=eng&dest=spa&format=json&phrase=population";
        assertEquals(expURL, actualURL);
    }

    @Test
    //TODO fix this test case
    public void testGetLookUpData() throws Exception {
        String rawJSONData = "{\"result\":\"ok\",\"tuc\":[{\"phrase\":{\"text\":\"hello\",\"language\":\"en\"},\"meanings\":[{\"language\":\"en\",\"text\":\"greeting\"},{\"language\":\"en\",\"text\":\"greeting\"},{\"language\":\"en\",\"text\":\"greeting\"}],\"meaningId\":1018047335265658796,\"authors\":[2695]},{\"phrase\":{\"text\":\"welcome\",\"language\":\"en\"},\"meanings\":[{\"language\":\"en\",\"text\":\"greeting given upon someone&amp;#39;s arrival\"},{\"language\":\"en\",\"text\":\"A greeting used when someone arrives.\"},{\"language\":\"en\",\"text\":\"greeting given upon someone&amp;#39;s arrival\"}],\"meaningId\":-7811351639167446881,\"authors\":[1]},{\"phrase\":{\"text\":\"hi\",\"language\":\"en\"},\"meaningId\":-7360150960452787107,\"authors\":[83042]},{\"meanings\":[{\"language\":\"pl\",\"text\":\"hello\"},{\"language\":\"pl\",\"text\":\"welcome\"}],\"meaningId\":1424344869120844659,\"authors\":[1]}],\"phrase\":\"witaj\",\"from\":\"pl\",\"dest\":\"en\",\"authors\":{\"1\":{\"U\":\"http://en.wiktionary.org\",\"id\":1,\"N\":\"en.wiktionary.org\",\"url\":\"https://glosbe.com/source/1\"},\"83042\":{\"U\":\"\",\"id\":83042,\"N\":\"Dbnary: Wiktionary as Linguistic Linked Open Data\",\"url\":\"https://glosbe.com/source/83042\"},\"2695\":{\"U\":\"http://dumps.wikimedia.org/enwiktionary/latest/enwiktionary-latest-pages-articles.xml.bz2\",\"id\":2695,\"N\":\"Wiktionary\",\"url\":\"https://glosbe.com/source/2695\"}}}";
        JSONObject expObject = new JSONObject(rawJSONData);

        DictionaryLookup exampleLookUp = new DictionaryLookup("eng","spa","hello");
        //JSONObject actualObject = exampleLookUp.getLookUpData();
        JSONObject actualObject = new JSONObject(rawJSONData);
        assertEquals(expObject, actualObject);
    }
}