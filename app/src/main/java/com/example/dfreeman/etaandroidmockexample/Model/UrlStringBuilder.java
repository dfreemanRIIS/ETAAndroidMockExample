package com.example.dfreeman.etaandroidmockexample.Model;

/**
 * Created by bmarshall on 3/29/17.
 */

public class UrlStringBuilder {

    public String getRoutesUrl(int company){
        return "http://ec2-204-236-211-33.compute-1.amazonaws.com:8080/companies/" + company + "/routes";
    }

    public String getStopsUrl(int company, String id, String direction, String days){
        return "http://ec2-204-236-211-33.compute-1.amazonaws.com:8080/companies/" +
                company + "/routes/" + id + "/" + direction + "/" + days + "/1/stops";
    }
}
