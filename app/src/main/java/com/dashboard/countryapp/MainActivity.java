package com.dashboard.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lstCountries;

    public static final String countries[] = {
            "Nepal", "Kathmandu",
            "India", "New Delhi",
            "China", "Beijing",
            "Uk", "London",
            "US", "Washingtong D.C",
            "Canada", "ottawa"
    };

    private Map<String, String> countriesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstCountries = findViewById(R.id.lstCountries);

        countriesMap = new HashMap<>();
        for (int i = 0; i < countries.length; i += 2) {
            countriesMap.put(countries[i], countries[i + 1]);

        }
        //Adding all the kry mao in to
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                new ArrayList<>(countriesMap.keySet())

        );
        lstCountries.setAdapter(arrayAdapter);

        lstCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = countriesMap.get(country);

                Toast.makeText(MainActivity.this, "capital" + capital, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
