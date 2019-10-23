package com.example.example1;

import java.io.File;

public class rootchecker {
    public static boolean path() {
        String[] arrayOfString = System.getenv("PATH").split(":");
        int i = arrayOfString.length;
        for (byte b = 0; b < i; b++) {
            if ((new File(arrayOfString[b], "su")).exists())
                return true;
        }
        return false;
    }
    public static boolean su() {
        String[] arrayOfString = new String[7];
        arrayOfString[0] = "/system/app/Superuser.apk";
        arrayOfString[1] = "/system/xbin/daemonsu";
        arrayOfString[2] = "/system/etc/init.d/99SuperSUDaemon";
        arrayOfString[3] = "/system/bin/.ext/.su";
        arrayOfString[4] = "/system/etc/.has_su_daemon";
        arrayOfString[5] = "/system/etc/.installed_su_daemon";
        arrayOfString[6] = "/dev/com.koushikdutta.superuser.daemon/";
        int i = arrayOfString.length;
        for (byte b = 0; b < i; b++) {
            if ((new File(arrayOfString[b])).exists())
                return true;
        }
        return false;
    }


}
