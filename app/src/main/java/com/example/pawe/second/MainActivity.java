package com.example.pawe.second;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeToastOnClick(View view) {
        Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show();

    }

    public void makeCustomToastOnClick(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.customToastLayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void makeNotificationOnClick(View view) {
        counter++;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_person_pin_circle_black_18dp)
                .setContentTitle("Tytuł")
                .setContentText(String.valueOf(counter))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,builder.build());
    }

    public void makeCustomNotificationOnClick(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "2")
                .setSmallIcon(R.drawable.ic_person_pin_circle_black_18dp)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentTitle("Tytuł")
                .setContentText("text")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.beeeaters)))
                .setAutoCancel(true);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(2,builder.build());
    }
}
