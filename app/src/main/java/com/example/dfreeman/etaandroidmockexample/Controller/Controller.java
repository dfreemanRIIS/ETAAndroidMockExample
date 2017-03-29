package com.example.dfreeman.etaandroidmockexample.Controller;

import com.example.dfreeman.etaandroidmockexample.Model.JsonFetcher;
import com.example.dfreeman.etaandroidmockexample.Model.JsonParser;
import com.example.dfreeman.etaandroidmockexample.Model.UrlStringBuilder;

import org.json.JSONException;

import java.util.ArrayList;

public class Controller {
    public String fetchUrl(String urlString) throws Exception {
        return JsonFetcher.fetchUrl(urlString);
    }

    public ArrayList<String> parseRoutes(String jsonString) throws JSONException {
        JsonParser parser = new JsonParser();
        return parser.parseRoutes(jsonString);
        
    private String getRoutesUrl(int company){
        UrlStringBuilder urlStringBuilder = new UrlStringBuilder();
        return urlStringBuilder.getRoutesUrl(company);
    }

    private String getStopsUrl(int company, String id, String direction, String days){
        UrlStringBuilder urlStringBuilder = new UrlStringBuilder();
        return urlStringBuilder.getStopsUrl(company, id, direction, days);
    }
}