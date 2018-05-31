package com.developing.iamlam.a06_intent_implicito;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ThirdActivity extends AppCompatActivity {

    private EditText etp;
    private EditText etw;
    private ImageButton ibp;
    private ImageButton ibw;

    private ImageButton ibc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etp=findViewById(R.id.editTextPhone);
        etw=findViewById(R.id.editTextWeb);
        ibp=findViewById(R.id.imageButtonPhone);
        ibw=findViewById(R.id.imageButtonWeb);
        ibc=findViewById(R.id.imageButtonCam);


        ibp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel=etp.getText().toString();

                if(tel!=null){

                    Intent itel=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tel));
                    startActivity(itel);

                }
            }
        });
    }
}
