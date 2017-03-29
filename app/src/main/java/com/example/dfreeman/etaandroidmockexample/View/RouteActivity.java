package com.example.dfreeman.etaandroidmockexample.View;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dfreeman.etaandroidmockexample.Controller.Controller;
import com.example.dfreeman.etaandroidmockexample.R;

import org.json.JSONException;

import java.util.ArrayList;

public class RouteActivity extends AppCompatActivity {

    public static final String EXTRA_COMPANY = "company";

    private ListView routeList;
    private String routeId;
    private String direction;
    private String days;
    private int companyNumber;
    private ArrayList<String> routeNumbers;
    private Controller controller;
    private Context context;
    private String jsonString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Intent intent = getIntent();
        companyNumber = intent.getIntExtra(EXTRA_COMPANY, -1);
        controller = new Controller();
        context = this;

        routeList = (ListView) findViewById(R.id.routes);

        routeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    routeId = controller.getRouteId(jsonString, position);
                    direction = controller.getDirection(jsonString, position);
                    days = controller.getDaysActive(jsonString, position);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(RouteActivity.this, StopActivity.class);
                intent.putExtra(StopActivity.EXTRA_COMPANY, companyNumber);
                intent.putExtra(StopActivity.EXTRA_ROUTEID, routeId);
                intent.putExtra(StopActivity.EXTRA_DIRECTION, direction);
                intent.putExtra(StopActivity.EXTRA_DAYS, days);
                startActivity(intent);
            }
        });

        new AsyncCaller().execute();
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                jsonString = controller.fetchUrl(controller.getRoutesUrl(companyNumber));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            try {
                routeNumbers = controller.parseRoutes(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            routeList.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, routeNumbers));
        }
    }
}
