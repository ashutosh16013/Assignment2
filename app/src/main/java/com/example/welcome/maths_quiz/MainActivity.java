package com.example.welcome.maths_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String m_set_ques="Click Next to Start the quiz";
    private static final String m_key = "Set_question";
    private static final String m_scorekey = "Set_marks_update";
    public int m_k,flag=0,flag_set_ques=0;
    public static String TAG="MyAPP : ";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mHint;
    private Button mCheat;
    private int mTotalScore = 0;
    public int result,flag_cheat=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button)findViewById(R.id.button);
        mFalseButton = (Button)findViewById(R.id.button2);
        mHint = (Button)findViewById(R.id.hint_button);
        mCheat = (Button)findViewById(R.id.cheat_button);
        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mHint.setOnClickListener(this);
        mCheat.setOnClickListener(this);

        if(savedInstanceState!=null){
            Log.d(TAG,"IsNotNull");
            m_set_ques = savedInstanceState.getString(m_key);
            if(m_set_ques.equals("Click Next to Start the quiz"))
            {
                TextView text1,text2;
                text1 = (TextView)findViewById(R.id.text);
                text2 = (TextView)findViewById(R.id.score);
                text1.setText("Click Next to Start the quiz");
                text2.setText("");
            }
            else {
                mTotalScore = savedInstanceState.getInt(m_scorekey);
                TextView text1, text2;
                text1 = (TextView) findViewById(R.id.text);
                text2 = (TextView) findViewById(R.id.score);
                text1.setText(m_set_ques);
                String score_to_text = String.valueOf(mTotalScore);
                text2.setText("Your Score " + score_to_text);
            }

        }
        Log.d(TAG,"Inside OnCreate");
    }

    @Override
    public void onClick(View v) {
        TextView score_text = (TextView)findViewById(R.id.score);
        String p;
        switch(v.getId()){

            case R.id.button:
                result = Main_Logic.check_prime(m_k);
                if(result==1&&flag==1){
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                    if(flag_cheat==0)
                        mTotalScore++;
                    flag=0;

                }

                if(result==0&&flag==1) {
                    Toast.makeText(getApplicationContext(), "InCorrect", Toast.LENGTH_SHORT).show();
                    if(flag_cheat==0)
                        mTotalScore--;
                    flag=0;
                }
                p = String.valueOf(mTotalScore);
                score_text.setText("Your Score "+p);
                break;
            case R.id.button2:
                result = Main_Logic.check_prime(m_k);
                if(result==0&&flag==1) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    if(flag_cheat==0)
                        mTotalScore++;
                    flag=0;
                }
                if(result==1&&flag==1) {
                    Toast.makeText(getApplicationContext(), "InCorrect", Toast.LENGTH_SHORT).show();
                    if(flag_cheat==0)
                        mTotalScore--;
                    flag=0;
                }
                p = String.valueOf(mTotalScore);
                score_text.setText("Your Score "+p);
                break;
            case R.id.hint_button:
                if(flag_set_ques==1)
                {
                    Intent hint_act = new Intent(MainActivity.this,hint.class);
                    hint_act.putExtra("MyQuestion",m_k);
                    startActivity(hint_act);
                }

                break;
            case R.id.cheat_button:
                if(flag_set_ques==1)
                {
                    Intent cheat_act = new Intent(MainActivity.this,cheat.class);
                    cheat_act.putExtra("MyQuestion",m_k);
                    flag_cheat=1;
                    startActivity(cheat_act);
                }

                break;
        }

    }

    public void change_text(View view){
        flag_set_ques = 1;
        flag_cheat = 0;
        TextView text;
        m_k = Main_Logic.generate_number();
        m_set_ques = "Is "+m_k+" a prime number ?";
        Log.d(TAG,m_set_ques);
        text = (TextView)findViewById(R.id.text);
        text.setText(m_set_ques);
        flag=1;
    }


    public void start_check(){

        Main_Logic.check_prime(m_k);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"Inside onStart");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Inside onDestroy");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside onDestroy");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside Pause");
    }

    @Override
    public void onStop(){

        super.onStop();
        Log.d(TAG,"Inside OnStop");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        // Save the user's current game state
        //super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(m_key, m_set_ques);
        savedInstanceState.putInt(m_scorekey,mTotalScore);
        super.onSaveInstanceState(savedInstanceState);

    }
}

