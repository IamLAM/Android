package com.developing.iamlam.a07_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.listView);

        List<String> nombres= new ArrayList<String>();

        nombres.add("Natalie");
        nombres.add("Pilar");
        nombres.add("Monica");
        nombres.add("Scarlett");
        nombres.add("Natalie");
        nombres.add("Pilar");
        nombres.add("Monica");
        nombres.add("Scarlett");
        nombres.add("Natalie");
        nombres.add("Pilar");
        nombres.add("Monica");
        nombres.add("Scarlett");
        nombres.add("Natalie");
        nombres.add("Pilar");
        nombres.add("Monica");
        nombres.add("Scarlett");
        nombres.add("Natalie");
        nombres.add("Pilar");
        nombres.add("Monica");
        nombres.add("Scarlett");
        // forma de visualizar
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        //enlazamos y desplegamos
        lv.setAdapter(adapter);

    }
}
