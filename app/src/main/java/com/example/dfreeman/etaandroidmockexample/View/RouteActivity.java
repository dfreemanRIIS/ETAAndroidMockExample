package com.example.dfreeman.etaandroidmockexample.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dfreeman.etaandroidmockexample.R;

public class RouteActivity extends AppCompatActivity {

    public static final String EXTRA_COMPANY = "company";
    private int company;
    private String routeId;
    private String direction;
    private String days;

    private String[] routeNumbers;
    private ListView routeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Intent intent = getIntent();
        company = intent.getIntExtra(EXTRA_COMPANY, -1);

        routeList = (ListView) findViewById(R.id.routes);
        routeNumbers = getResources().getStringArray(R.array.testRoutes);
        routeList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, routeNumbers));

        routeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                routeId = "1";
                direction = "northbound";
                days = "everyday";

                Intent intent = new Intent(RouteActivity.this, StopActivity.class);
                intent.putExtra(StopActivity.EXTRA_COMPANY, company);
                intent.putExtra(StopActivity.EXTRA_ROUTEID, routeId);
                intent.putExtra(StopActivity.EXTRA_DIRECTION, direction);
                intent.putExtra(StopActivity.EXTRA_DAYS, days);
                startActivity(intent);
            }
        });
    }
}
