package sraut.com.broadcastreceiver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String intentAction = intent.getAction();
        String toastMessage = "Unknown intent action";

        switch (intentAction) {
            case Intent.ACTION_POWER_CONNECTED:
                toastMessage = "Power connected";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                toastMessage = "Power disconnected";
                break;

                //2
            case ACTION_CUSTOM_BROADCAST:
                toastMessage = "Custom Broadcast Received";
                break;
            }

            Toast.makeText(context,toastMessage,Toast.LENGTH_LONG).show();

    }
}

