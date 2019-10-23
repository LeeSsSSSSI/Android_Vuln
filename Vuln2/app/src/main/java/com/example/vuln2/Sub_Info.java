package com.example.vuln2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.securepreferences.SecurePreferences;

public class Sub_Info extends AppCompatActivity {


    EditText edit_save;
    String shared = "password";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_info);

        edit_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("password","");
        edit_save.setText(value);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        String value = edit_save.getText().toString();
        SharedPreferences prefs = new SecurePreferences(Sub_Info.this,"password", "password");
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("password",value);
        editor.commit();




    }
}
