package com.example.example1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.System.*;

public class MainActivity extends AppCompatActivity {
    private void a(String paramString) {
        AlertDialog alertDialog = (new AlertDialog.Builder( this )).create();
        alertDialog.setTitle( paramString );
        alertDialog.setMessage( "OS 변조가 탐지되어 종료합니다" );
        alertDialog.setButton( -3, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                exit( 0 );
            }
        } );
        alertDialog.setCancelable( false );
        alertDialog.show();
    }
    /*
    private void getSignature()  {

        @SuppressLint("PackageManagerGetSignatures")
        PackageInfo packageInfo = null;
        TextView pkgInfoTxt = (TextView) findViewById(R.id.pkg_test);
        try {
            packageInfo = this.getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_SIGNATURES);
            String sigString = "";


            //안드로이드는 여러 키스토어로 Signing 가능, 일반적으로는 하나의 키스토어로만 Signing함.
            for (Signature sig : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(sig.toByteArray());
                String currentSignature = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                sigString += "["+currentSignature+"], ";

            }
            pkgInfoTxt.setText("sigs: "+sigString);

            if(sigString.equals("[123=")){
                Toast.makeText( getApplicationContext(),"정상앱입니다",Toast.LENGTH_SHORT).show();
            }
        else
            {
                System.exit(0);
            }

        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException  e) {
            e.printStackTrace();
        }
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (rootchecker.path() || rootchecker.su())
            a( "루팅 확인" );
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_main );
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.example1", PackageManager.GET_SIGNATURES);
            String sigString = "";
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String currentSignature = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                sigString += "["+currentSignature+"], ";
            }
            if(sigString.equals("123" )){

            }else
            {
                System.exit(0);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

}