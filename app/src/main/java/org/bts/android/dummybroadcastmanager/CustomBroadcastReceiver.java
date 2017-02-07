package org.bts.android.dummybroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = CustomBroadcastReceiver.class.getSimpleName();

    public CustomBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        switch (intent.getAction()) {
            case "org.bts.android.CUSTOM_ACTION":
                Log.v(CustomBroadcastReceiver.TAG, "Custom Broadcast Captured");
                Toast.makeText(context, "Custom Action triggered", Toast.LENGTH_LONG).show();
                break;
            case "org.bts.android.LOCAL_ACTION":
                Log.v(CustomBroadcastReceiver.TAG, "Local Broadcast Captured!");
                Toast.makeText(context, "Local Action triggered", Toast.LENGTH_LONG).show();
                break;
            default:
                Log.v(CustomBroadcastReceiver.TAG, "Nothing Happened");
                break;
        }

    }
}
