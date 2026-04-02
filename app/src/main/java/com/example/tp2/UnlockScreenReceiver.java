package com.example.tp2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class UnlockScreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (Intent.ACTION_USER_PRESENT.equals(action)) {
            Toast.makeText(context, "Screen Unlocked!", Toast.LENGTH_LONG).show();

            Log.d("UNLOCK RECEIVER", "Screen unlocked event captured.");

            var callIntent = new Intent(Intent.ACTION_DIAL);

            callIntent.setData(Uri.parse("tel:2664553747"));

            // INFO: Hay que settear en el intent la flag de nueva tarea, ya que estamos invocandolo
            // desde un BroadcastReceiver y estos no tienen activity propia.
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(callIntent);
        }
    }
}