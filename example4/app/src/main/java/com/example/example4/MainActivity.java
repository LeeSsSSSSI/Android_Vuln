package com.example.example4;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        final EditText editText=(EditText)findViewById(R.id.editText);

        final EditText editText2=(EditText)findViewById(R.id.editText2);

        Button button=(Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                //해당 버튼이 클릭 되었을때 각각의 editText 값을 읽어옴

                final String loginid = editText.getText().toString();

                final String pw = editText2.getText().toString();

                //각각의 editText 값을 읽어온것을 토대로 조건에 맞게 유효성 검사를 시작

                //조건에 맞는다면 로그인 다음으로 진행되고 아닐시 Toast로 경고문을 띄워줌

                if(loginid.equals( "admin" )  &&  pw.equals("123") ) {

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    startActivity(intent);

                }else{

                    Toast.makeText(MainActivity.this,"아이디 또는 패스워드를 확인해주세요", Toast.LENGTH_LONG).show();

                }

            }

        });

    }

}
