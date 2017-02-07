package org.bts.android.dummybroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private static final String TAG = MainActivity.class.getSimpleName();

    private BroadcastReceiver CustomBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button trgCustomBroadcast = (Button) findViewById(R.id.btnTrigBroadcast);
        trgCustomBroadcast.setOnClickListener(this);

        final Button trgLocalBroadcast = (Button) findViewById(R.id.btnTrigLocalBroadcast);
        trgLocalBroadcast.setOnClickListener(this);

        this.CustomBroadcastReceiver = new CustomBroadcastReceiver();

        LocalBroadcastManager.getInstance(this).registerReceiver(this.CustomBroadcastReceiver, new IntentFilter("org.bts.android.LOCAL_ACTION"));
    }


    @Override
    protected void onPause() {
        super.onPause();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.CustomBroadcastReceiver);
    }

    @Override
    public void onClick(View whichView) {

        switch (whichView.getId()) {

            case R.id.btnTrigBroadcast:
                Log.w(MainActivity.TAG, "Custom Broadcast Triggered");
                Intent CustomBroadcastIntent = new Intent();
                CustomBroadcastIntent.setAction("org.bts.android.CUSTOM_ACTION");
                this.sendBroadcast(CustomBroadcastIntent);
                break;

            case R.id.btnTrigLocalBroadcast:
                Log.w(MainActivity.TAG, "Local Broadcast Triggered");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent().setAction("org.bts.android.LOCAL_ACTION"));
                break;

            default:
                Log.w(MainActivity.TAG, "Something else Clicked");
                break;

        }

    }
}


