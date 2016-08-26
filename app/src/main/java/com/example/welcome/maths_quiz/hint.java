package com.example.welcome.maths_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class hint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        Bundle hint_access = getIntent().getExtras();
        int k = hint_access.getInt("MyQuestion");
        TextView hint = (TextView)findViewById(R.id.hint_text);
        String p = String.valueOf(k);
        hint.setText("Try Factorising the number "+p);

    }

    @Override
    protected void onDestroy(){

        super.onDestroy();
        Toast.makeText(getApplicationContext(), "You Used Hint", Toast.LENGTH_SHORT).show();

    }
}
