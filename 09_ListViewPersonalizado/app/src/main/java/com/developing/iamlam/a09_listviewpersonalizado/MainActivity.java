package com.developing.iamlam.a09_listviewpersonalizado;

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

    ListView lv;
    List<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //se busca el componente
        lv=findViewById(R.id.listViewContactos);
        //se crea la lista
        nombres=new ArrayList<String>();

        nombres.add("Monica");
        nombres.add("Pilar");
        nombres.add("Elizabeth");
        nombres.add("Laura");
        nombres.add("Evelyn");
        //se crea el adaptador y se enlazada componente-datos
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        lv.setAdapter(adapter);
        // se detecta si se realizo un click sobre la superficie
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"El contacto presionado es "+nombres.get(position),Toast.LENGTH_LONG).show();

            }
        });


    }
}
