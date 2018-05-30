package com.developing.iamlam.a05_intent_explicito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private String saludar="Hola ¿como estas?";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.buttonM);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Vinculo por intent activities
                Intent ints =new Intent(MainActivity.this,SecondActivity.class);
                ints.putExtra("saludo",saludar);

                startActivity(ints);
            }
        });

    }
}
