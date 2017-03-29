package com.example.dfreeman.etaandroidmockexample.View;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dfreeman.etaandroidmockexample.Controller.Controller;
import com.example.dfreeman.etaandroidmockexample.R;

import java.util.ArrayList;

public class RouteActivity extends AppCompatActivity {

    public static final String EXTRA_COMPANY = "company";
    private int company;
    private ArrayList<String> routeNumbers;
    private Controller controller;
    private String bla = "";
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Intent intent = getIntent();
        company = intent.getIntExtra(EXTRA_COMPANY, -1);
        controller = new Controller();
        test = (TextView) findViewById(R.id.test);
        new AsyncCaller().execute();
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                bla = controller.fetchUrl(controller.getRoutesUrl(company));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            test.setText(bla);
        }

    }
}
