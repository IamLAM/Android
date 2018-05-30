package com.developing.iamlam.a04_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Forma recomendada para vincularse con la UI
        btn=findViewById(R.id.buttonM);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hola bienvenido a Android",Toast.LENGTH_LONG).show();
            }
        });
    }

/*
Forma de vincular con la UI
    public void desplegar(View v)
    {

        System.out.println("Entro a funcion");


    }*/


}
