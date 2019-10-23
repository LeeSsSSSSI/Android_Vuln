package com.example.vuln2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_test;
    Button btn_test2;
    Button btn_test3;
    Button btn_test4;
    ImageView test;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn_test4 = (Button) findViewById(R.id.btn_text4);
        btn_test4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sub_Info.class);
                startActivity(intent);
            }
        });

        btn_test3 = (Button) findViewById(R.id.btn_text3);
        btn_test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sub_background.class);
                startActivity(intent);
            }
        });

        btn_test2 = (Button) findViewById(R.id.btn_text2);
        btn_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sub_debugcheck.class);
                startActivity(intent);
            }
        });

        btn_test = (Button) findViewById(R.id.btn_text);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sub_rootcheck.class);
                startActivity(intent);
            }
        });

        test = (ImageView) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "그냥 넣어 놓은것", Toast.LENGTH_SHORT).show();
            }

        });


    }

}
