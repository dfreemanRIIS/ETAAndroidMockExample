package com.example.dfreeman.etaandroidmockexample.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dfreeman.etaandroidmockexample.R;

public class CompanyActivity extends AppCompatActivity {

    private String[] busNamesArray;

    private ListView busListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        busNamesArray = getResources().getStringArray(R.array.busnames);
        busListView = (ListView) findViewById(R.id.busses);
        busListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, busNamesArray));

        busListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CompanyActivity.this, RouteActivity.class);
                intent.putExtra(RouteActivity.EXTRA_COMPANY, position + 1);
                startActivity(intent);
            }
        });
    }
}
