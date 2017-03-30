package com.example.dfreeman.etaandroidmockexample.View;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dfreeman.etaandroidmockexample.Controller.Controller;
import com.example.dfreeman.etaandroidmockexample.R;

import java.util.ArrayList;

public class StopActivity extends AppCompatActivity {
    private int companyNumber;
    private String routeId;
    private String direction;
    private String days;
    private ArrayList<String> stops;
    private ListView stopsList;
    private String jsonString;
    private Controller controller;
    private Context context;
    private TextView test;

    public static final String EXTRA_COMPANY = "company";
    public static final String EXTRA_ROUTEID = "routeid";
    public static final String EXTRA_DIRECTION = "direction";
    public static final String EXTRA_DAYS = "days";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);
        Intent intent = getIntent();
        companyNumber = intent.getIntExtra(EXTRA_COMPANY, -1);
        routeId = intent.getStringExtra(EXTRA_ROUTEID);
        direction = intent.getStringExtra(EXTRA_DIRECTION);
        days = intent.getStringExtra(EXTRA_DAYS);
        stopsList = (ListView) findViewById(R.id.stops);
        controller = new Controller();
        context = this;

        //if days has more than one value, grab first value
        int spaceIndex = days.indexOf(",");
        if (spaceIndex != -1)
        {
            days = days.substring(0, spaceIndex);
        }

        new AsyncCaller().execute();
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                jsonString = controller.fetchUrl(controller.getStopsUrl(companyNumber, routeId,
                        direction, days));
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
