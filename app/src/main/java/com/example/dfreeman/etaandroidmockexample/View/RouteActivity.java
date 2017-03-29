package com.example.dfreeman.etaandroidmockexample.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dfreeman.etaandroidmockexample.R;

public class RouteActivity extends AppCompatActivity {

    public static final String EXTRA_COMPANY = "company";
    private int company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Intent intent = getIntent();
        company = intent.getIntExtra(EXTRA_COMPANY, -1);
    }
}
