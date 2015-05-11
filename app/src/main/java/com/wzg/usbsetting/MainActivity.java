package com.wzg.usbsetting;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.wzg.smallandroidutil.device.USBHelper;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClicked();
        finish();
    }

    private void displayAndroidUsbSetting(Context context) {
        Intent usbIntent=new Intent("/");
        ComponentName cn=new ComponentName("com.android.settings", "com.android.settings.UsbSettings");

        usbIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        usbIntent.setComponent(cn);
        context.startActivity(usbIntent);
    }

    private void onClicked() {
        // Log.d(TAG, "clicked");
        boolean isUsbPlugged = USBHelper.getInstance().isPlugged(this);
        //  Log.d(TAG, "isUsbPlugged:" + isUsbPlugged);
        if (!isUsbPlugged) {
            String msg = (String) this.getResources().getText(R.string.usb_not_plugged);
            Toast.makeText(this, msg,
                    Toast.LENGTH_LONG).show();
            return;
        }


        displayAndroidUsbSetting(this);
    }
    public MainActivity() {

    }
}
