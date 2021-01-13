package edu.monash.legoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SaleLists extends AppCompatActivity {
    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_lists);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        backBtn = findViewById(R.id.backBtnSaleList);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setText("");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });
        ImageView view = findViewById(R.id.imageView6);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.homepage_activity);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homepage_activity:
                        startActivity(new Intent(getApplicationContext(), Homepage.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.search_activity:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.camera_activity:
                        startActivity(new Intent(getApplicationContext(), UnityActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.CLism.LegoAR");
//                        if (launchIntent != null) {
//                            startActivity(launchIntent);
//                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                        } else {
//                            Toast.makeText(MainActivity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
//                        }

                        return true;
                    case R.id.cart_activity:
                        startActivity(new Intent(getApplicationContext(), Cart.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.account_activity:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                }
                return false;
            }
        });
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
                        ImageView img = (ImageView) findViewById(R.id.imageView5);
                        int touchColor = AppUtilities.getHotspotColor(img, x, y);
                        AppUtilities.compareColorNavigation(touchColor, SaleLists.this);
                        break;
                }
                return true;
            }
        });
    }
}