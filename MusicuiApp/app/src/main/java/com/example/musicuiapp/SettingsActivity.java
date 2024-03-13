package com.example.musicuiapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    private final String CHANNEL_ID = "personal notifications";
    private final int NOTIFICATION_ID = 001;
    Switch switchNotification;
    ImageButton btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        switchNotification = findViewById(R.id.switchNotification);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(SettingsActivity.this, SplashLogoActivity.class);//when user click logout it will go to splash logo
                        Toast.makeText(SettingsActivity.this, "You are logged out", Toast.LENGTH_SHORT).show(); //pop up message

                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });
    }


    public void setSwitchNotification(View view) { //method when i press on the switch
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.splashlogo); //this will be my app icon when the notification pops up
        //builder.setContentTitle("Musicui");
        builder.setContentText("You last listened to boy with love!"); // what the notification says.
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) //This statement is true,as my device is running on android SDK 26 and above,this IF statement will be executed.
        {
            CharSequence name = "Personal Notifications";
            String description = "Include all the personal notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);

            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


            notificationManager.createNotificationChannel(notificationChannel); //using notification object,we create the channel
        }
    }
}
