package com.example.dfreeman.etaandroidmockexample.Controller;

import com.example.dfreeman.etaandroidmockexample.Model.JsonFetcher;
import com.example.dfreeman.etaandroidmockexample.Model.JsonParser;
import com.example.dfreeman.etaandroidmockexample.Model.UrlStringBuilder;

import org.json.JSONException;

import java.util.ArrayList;

public class Controller {
    private JsonParser parser;
    private UrlStringBuilder urlStringBuilder;

    public Controller(){
        parser = new JsonParser();
        urlStringBuilder = new UrlStringBuilder();
    }
    public String fetchUrl(String urlString) throws Exception {
        return JsonFetcher.fetchUrl(urlString);
    }

    public ArrayList<String> parseRoutes(String jsonString) throws JSONException {
        return parser.parseRoutes(jsonString);
    }

    public ArrayList<String> getStops(String jsonString) throws JSONException {
        return parser.getStops(jsonString);
    }
        
    public String getRoutesUrl(int company){
        return urlStringBuilder.getRoutesUrl(company);
    }

    public String getStopsUrl(int companyNumber, String routeId, String direction, String daysActive){
        return urlStringBuilder.getStopsUrl(companyNumber, routeId, direction, daysActive);
    }

    public String getDirection(String jsonString, int index) throws JSONException {
        return parser.getDirection(jsonString, index);
    }

    public String getRouteId(String jsonString, int index) throws JSONException {
        return parser.getRouteId(jsonString, index);
    }

    public String getDaysActive(String jsonString, int index) throws JSONException {
        return parser.getDaysActive(jsonString, index);
    }
}