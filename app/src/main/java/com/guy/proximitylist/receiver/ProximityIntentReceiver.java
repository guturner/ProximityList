package com.guy.proximitylist.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;

/**
 * Created by Guy on 3/11/2015.
 */
public class ProximityIntentReceiver extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        String key = LocationManager.KEY_PROXIMITY_ENTERING;

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, null, 0);
        Notification notification   = createNotification();

        notification.setLatestEventInfo(context, "Proximity Alert!", "You are near your point of interest!", pendingIntent);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    private Notification createNotification() {
        Notification notification = new Notification();

        notification.when = System.currentTimeMillis();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;

        notification.ledARGB  = Color.WHITE;
        notification.ledOnMS  = 1500;
        notification.ledOffMS = 1500;

        return notification;
    }
}
