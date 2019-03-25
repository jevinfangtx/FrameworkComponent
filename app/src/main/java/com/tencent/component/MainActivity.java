package com.tencent.component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String text = "jevin\rfang";
        TextView textView = findViewById(R.id.textview);
        textView.setText(text);
    }
}
