package edu.monash.legoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ImageView view = findViewById(R.id.imageView19);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                String msg;
                int action = event.getActionMasked();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
//                        msg = "Down X="+x+",  Y="+y;
//                        Toast.makeText(MainActivity.this, msg,
//                                Toast.LENGTH_LONG).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        msg = "Move X="+x+",  Y="+y;
//
//                        Toast.makeText(MainActivity.this, msg,
//                                Toast.LENGTH_LONG).show();
                        break;
                    case MotionEvent.ACTION_UP:
//                        msg = "UP X="+x+",  Y="+y;
//                        Toast.makeText(MainActivity.this, msg,
//                                Toast.LENGTH_LONG).show();
                        ImageView img = (ImageView) findViewById(R.id.imageView18);
                        int touchColor = AppUtilities.getHotspotColor(img, x, y);
                        AppUtilities.compareColorNavigation(touchColor, Account.this);
                        overridePendingTransition(R.anim.left_in, R.anim.right_out);
                        break;
                }
                return true;
            }
        });
    }
}