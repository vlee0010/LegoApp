package edu.monash.legoar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ImageView view = findViewById(R.id.imageView22);
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
                        ImageView img = (ImageView) findViewById(R.id.imageView21);
                        int touchColor = AppUtilities.getHotspotColor(img, x, y);
                        AppUtilities.compareColorNavigation(touchColor, Contact.this);
                        overridePendingTransition(R.anim.left_in, R.anim.right_out);
                        break;
                }
                return true;
            }
        });
    }
}