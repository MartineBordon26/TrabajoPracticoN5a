package com.martinbordon.trabajopracticon5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class BroadcastLlamar extends BroadcastReceiver {

    private Context context;
    Intent llamadaIntent = new Intent(Intent.ACTION_CALL);

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isConnected = intent.getBooleanExtra("connected", false);
        Log.d("salida", isConnected+"");
       if(isConnected) {
            llamadaIntent.setData(Uri.parse("tel:" + "2664553747"));
            llamadaIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(llamadaIntent);
       }
    }
}
