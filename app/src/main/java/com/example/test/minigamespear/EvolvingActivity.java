package com.example.test.minigamespear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;


public class EvolvingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolving);

        Button eYC =(Button)findViewById(R.id.button);
        eYC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EvolvingActivity.this, StatisticMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}