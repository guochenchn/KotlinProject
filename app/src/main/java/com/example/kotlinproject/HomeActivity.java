package com.example.kotlinproject;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hoem);
        TextView textview = findViewById(R.id.tv_text);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilsTwo.INSTANCE.showToast(HomeActivity.this,"点击了我");
            }
        });

        new TextView(this).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
