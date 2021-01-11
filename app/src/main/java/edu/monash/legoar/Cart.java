package edu.monash.legoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Cart extends AppCompatActivity {
    private Button backBtn;
    private Button commitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        backBtn = findViewById(R.id.backBtnCart);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setText("");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });

        commitbtn = findViewById(R.id.commitBtn);
        commitbtn.setBackgroundColor(Color.TRANSPARENT);
        commitbtn.setText("");
        commitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AppUtilities.startNewActivity(Cart.this, CheckOut.class);
            }
        });
    }
}