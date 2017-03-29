package com.example.dfreeman.etaandroidmockexample.Controller;

import com.example.dfreeman.etaandroidmockexample.Model.JsonFetcher;
import com.example.dfreeman.etaandroidmockexample.Model.UrlStringBuilder;

public class Controller {
    public String fetchUrl(String urlString) throws Exception {
        return JsonFetcher.fetchUrl(urlString);
    }

    private String getRoutesUrl(int company){
        UrlStringBuilder urlStringBuilder = new UrlStringBuilder();
        return urlStringBuilder.getRoutesUrl(company);
    }

    private String getStopsUrl(int company, String id, String direction, String days){
        UrlStringBuilder urlStringBuilder = new UrlStringBuilder();
        return urlStringBuilder.getStopsUrl(company, id, direction, days);
    }
}