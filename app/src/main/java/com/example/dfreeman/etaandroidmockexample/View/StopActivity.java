package com.example.dfreeman.etaandroidmockexample.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dfreeman.etaandroidmockexample.R;

public class StopActivity extends AppCompatActivity {
    private int company;
    private String routeId;
    private String direction;
    private String days;

    public static final String EXTRA_COMPANY = "company";
    public static final String EXTRA_ROUTEID = "routeid";
    public static final String EXTRA_DIRECTION = "direction";
    public static final String EXTRA_DAYS = "days";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);
    }
}
