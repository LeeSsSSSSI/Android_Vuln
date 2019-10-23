package com.example.exampl2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class integrity extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.integrity );
        getSignature();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void getSignature() {

        @SuppressLint("PackageManagerGetSignatures")
        PackageInfo packageInfo = null;
        TextView pkgInfoTxt = findViewById( R.id.pkg_test2 );
        try {
            packageInfo = this.getPackageManager().getPackageInfo( this.getPackageName(), PackageManager.GET_SIGNATURES );
            String sigString = "";

            //안드로이드는 여러 키스토어로 Signing 가능, 일반적으로는 하나의 키스토어로만 Signing함.
            for (Signature sig : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance( "SHA-1");
                md.update( sig.toByteArray() );
                String currentSignature = Base64.encodeToString( md.digest(), Base64.DEFAULT );
                sigString +=currentSignature;
            }

            Log.e("Hash key", sigString);


            String origin = "CWVYjYmYux6WSNUNjQHAUggNJSg=";
            String origin1 = sigString.toString().replaceAll("\\P{Print}","").trim();
            if(origin1.equals( origin) ){
                Toast toast = Toast.makeText(this,"변조되지 않은 앱입니다.",  Toast.LENGTH_SHORT);
                toast.show();
                pkgInfoTxt.setText(sigString);
            }else{
                Toast toast = Toast.makeText(this, "변조된 앱은 자동종료 됩니다", Toast.LENGTH_SHORT);
                toast.show();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();
                }



            }

        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
