package edu.monash.legoar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckOut extends AppCompatActivity {
    private Button backBtn;
    private Button commitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        backBtn = findViewById(R.id.backBtnCheckout);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setText("");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });

        commitbtn = findViewById(R.id.commitBtnCheckout);
        commitbtn.setBackgroundColor(Color.TRANSPARENT);
        commitbtn.setText("");
        commitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUtilities.startNewActivity(CheckOut.this, OrderStatus.class);
            }
        });
    }
}