package edu.monash.legoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class productDetails extends AppCompatActivity {
    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        backBtn = findViewById(R.id.backBtnDetails);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setText("");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });
        ImageView view = findViewById(R.id.imageView2);
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
                        ImageView img = (ImageView) findViewById(R.id.imageView);
                        int touchColor = AppUtilities.getHotspotColor(img, x, y);
                        AppUtilities.compareColorNavigation(touchColor, productDetails.this);
                        break;
                }
                return true;
            }
        });
    }
}