package com.example.aeroplanemode_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb =new StringBuilder();
        sb.append("Action : "+intent.getAction()+"\n");
        sb.append("URI : "+intent.toUri(Intent.URI_INTENT_SCHEME).toString()+"\n");
        String log = sb.toString();
        Log.d("My Broadcast Reciever",log);
        Toast.makeText(context,log,Toast.LENGTH_LONG).show();
    }
}
