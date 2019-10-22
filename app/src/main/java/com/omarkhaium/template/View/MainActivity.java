package com.omarkhaium.template.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.omarkhaium.template.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
    }
}
