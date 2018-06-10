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
    private EditText etm;
    private ImageButton ibp;
    private ImageButton ibw;
    private ImageButton ibm;
    private ImageButton ibcon;

    private ImageButton ibc;
    private final int PCC = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
//se carga el icono de la app
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_logoapp_round);

        etp = findViewById(R.id.editTextPhone);
        etw = findViewById(R.id.editTextWeb);
        etm = findViewById(R.id.editTextMail);
        ibp = findViewById(R.id.imageButtonPhone);
        ibw = findViewById(R.id.imageButtonWeb);
        ibc = findViewById(R.id.imageButtonCam);
        ibcon = findViewById(R.id.imageButtonContacto);
        ibm = findViewById(R.id.imageButtonMail);

        ibp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = etp.getText().toString();

                if (tel != null && !tel.isEmpty()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PCC);
                    } else {

                        oV(tel);
                    }

                } else {


                    Toast.makeText(ThirdActivity.this, "Por favor incluye un numero de telefono", Toast.LENGTH_SHORT).show();

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

        //boton para web

        ibw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etw.getText().toString();
                if (url != null && !url.isEmpty()) {

                    Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
                    startActivity(intentWeb);


                }
            }
        });
// acceso a contactos
        ibcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContact = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                startActivity(intentContact);
            }
        });


        //acceso a correo

        ibm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = etm.getText().toString();

                Intent intentMail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + correo));
                startActivity(intentMail);
            }
        });


//acceso a camara

        ibc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCam=new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intentCam);
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //verificamos el tipo de servicio


        switch (requestCode) {

            case PCC:
                String permission = permissions[0];
                int result = grantResults[0];

                //comprobamos si se tiene privilegios
                if (result == PackageManager.PERMISSION_GRANTED) {

                    String tel = etp.getText().toString();
                    Intent itel = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                        return;
                    startActivity(itel);


                } else {

                    Toast.makeText(ThirdActivity.this, "Acceso Denegado", Toast.LENGTH_SHORT).show();
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
