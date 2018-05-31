package com.developing.iamlam.a06_intent_implicito;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private EditText etp;
    private EditText etw;
    private ImageButton ibp;
    private ImageButton ibw;

    private ImageButton ibc;
    private final int PCC = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etp = findViewById(R.id.editTextPhone);
        etw = findViewById(R.id.editTextWeb);
        ibp = findViewById(R.id.imageButtonPhone);
        ibw = findViewById(R.id.imageButtonWeb);
        ibc = findViewById(R.id.imageButtonCam);


        ibp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = etp.getText().toString();

                if (tel != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PCC);
                    } else {

                        oV(tel);
                    }

                }
            }

            //validamos la version
            private void oV(String tel) {

                Intent itel = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
                if (CheckPermission(Manifest.permission.CALL_PHONE)) {

                    startActivity(itel);

                } else {

                    Toast.makeText(ThirdActivity.this, "No se tienen los privilegios", Toast.LENGTH_SHORT).show();
                }


            }


        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //verificamos el tipo de servicio


        switch(requestCode){

            case PCC:
                    String permission=permissions[0];
                    int result=grantResults[0];

                    //comprobamos si se tiene privilegios
                if(result==PackageManager.PERMISSION_GRANTED){

                    String tel=etp.getText().toString();
                    Intent itel=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+tel));
                    if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED) return;
                    startActivity(itel);


                }else{

                    Toast.makeText(ThirdActivity.this,"Acceso Denegado",Toast.LENGTH_SHORT).show();
                }
                break;


            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    break;


        }

    }

    //Nos ayuda a comprobar si se tienen los permisos en el manifest
    private boolean CheckPermission(String permission) {

        int r = this.checkCallingOrSelfPermission(permission);
        return r == PackageManager.PERMISSION_GRANTED;


    }
}
