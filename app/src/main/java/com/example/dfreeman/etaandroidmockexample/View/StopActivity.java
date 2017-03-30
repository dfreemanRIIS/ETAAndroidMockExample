package com.example.dfreeman.etaandroidmockexample.View;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.example.dfreeman.etaandroidmockexample.Controller.Controller;
import com.example.dfreeman.etaandroidmockexample.R;

import java.util.ArrayList;

public class StopActivity extends AppCompatActivity {
    private int companyNumber;
    private String routeId;
    private String currentDirection;
    private String direction1;
    private String direction2;
    private String days;
    private ArrayList<String> stops;
    private ListView stopsList;
    private String jsonString;
    private Controller controller;
    private Context context;
    private ToggleButton directionButton;

    public static final String EXTRA_COMPANY = "company";
    public static final String EXTRA_ROUTEID = "routeid";
    public static final String EXTRA_DIRECTION = "direction1";
    public static final String EXTRA_DAYS = "days";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);
        Intent intent = getIntent();
        companyNumber = intent.getIntExtra(EXTRA_COMPANY, -1);
        routeId = intent.getStringExtra(EXTRA_ROUTEID);
        direction1 = intent.getStringExtra(EXTRA_DIRECTION);
        days = intent.getStringExtra(EXTRA_DAYS);
        stopsList = (ListView) findViewById(R.id.stops);
        controller = new Controller();
        context = this;
        directionButton = (ToggleButton) findViewById(R.id.directionButton);
        directionButton.setTextOff(direction1);

        if (direction1.equals("Northbound")) {
            directionButton.setTextOn("Southbound");
            direction2 = "Southbound";
        } else {
            directionButton.setTextOn("Westbound");
            direction2 = "Westbound";
        }
        directionButton.setChecked(false);

        //if days has more than one value, grab first value
        int commaIndex = days.indexOf(",");
        if (commaIndex != -1) {
            days = days.substring(0, commaIndex);
        }

        currentDirection = direction1;

        directionButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    currentDirection = direction2;
                } else {
                    currentDirection = direction1;
                }
                new AsyncCaller().execute();
            }
        });

        new AsyncCaller().execute();
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                jsonString = controller.fetchUrl(controller.getStopsUrl(companyNumber, routeId,
                        currentDirection, days));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            try {
                stops = controller.getStops(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stopsList.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, stops));
        }
    }
}
