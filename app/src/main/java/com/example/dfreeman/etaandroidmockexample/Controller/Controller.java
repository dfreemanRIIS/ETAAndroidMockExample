package com.example.dfreeman.etaandroidmockexample.Controller;

import com.example.dfreeman.etaandroidmockexample.Model.JsonFetcher;

public class Controller {
    public String fetchUrl(String urlString) throws Exception {
        return JsonFetcher.fetchUrl(urlString);
    }
}