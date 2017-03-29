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
    }

    public ArrayList<String> getStops(String jsonString) throws JSONException {
        JsonParser parser = new JsonParser();
        return parser.getStops(jsonString);
    }
        
    public String getRoutesUrl(int company){
        UrlStringBuilder urlStringBuilder = new UrlStringBuilder();
        return urlStringBuilder.getRoutesUrl(company);
    }

    public String getStopsUrl(int company, String routeId, String direction, String days){
        UrlStringBuilder urlStringBuilder = new UrlStringBuilder();
        return urlStringBuilder.getStopsUrl(company, routeId, direction, days);
    }
}