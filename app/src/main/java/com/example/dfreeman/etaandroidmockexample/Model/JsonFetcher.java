package com.example.dfreeman.etaandroidmockexample.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonFetcher {

    //Download the URL as text
    public static String fetchUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}