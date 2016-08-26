package com.example.welcome.maths_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class cheat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Bundle hint_access = getIntent().getExtras();
        int k = hint_access.getInt("MyQuestion");
        TextView cheat = (TextView)findViewById(R.id.cheat_text);
        String p = String.valueOf(k);
        int factor = 0;
        for(int i=1;i<k;i++){

            if(k%i==0){
                factor=k;
                break;
            }
        }
    if(factor==0)
        cheat.setText("Number has no factors so it is prime");
    else
        {
            String p1 = String.valueOf(k);
            cheat.setText("One of the factors is"+p1+"So it cannot be prime");
        }
    }
}
