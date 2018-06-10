package com.developing.iamlam.a08_listviewclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    List<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//buscamos el listview
        lv = findViewById(R.id.listViewNombres);


        nombres = new ArrayList<String>();

        nombres.add("Pilar");
        nombres.add("Penelope");
        nombres.add("Eva");
        nombres.add("Elizabeth");
        //unimos la lista con el adaptador para visualizar

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombres);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Se presiono sobre " + nombres.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }
}
