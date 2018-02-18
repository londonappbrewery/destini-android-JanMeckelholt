package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextViewStory;
    Button mButtonTop;
    Button mButtonBottom;
    int mCurrentPosition;
    QAPair mCurrentQAPair;

    private QAPair[] mQAPairBank = new QAPair[]{
            new QAPair(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new QAPair(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new QAPair(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new QAPair(R.string.T4_End, R.string.T_End, R.string.T_End),
            new QAPair(R.string.T5_End, R.string.T_End, R.string.T_End),
            new QAPair(R.string.T6_End, R.string.T_End, R.string.T_End),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt("PositionKey");
        }
        else {
            mCurrentPosition = 0;
        }

        mCurrentQAPair = mQAPairBank[mCurrentPosition];


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextViewStory = (TextView) findViewById(R.id.storyTextView);
        mButtonTop  = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        updateQA();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Top Button pressed", Toast.LENGTH_SHORT).show();
                nextStep(true);
                updateQA();

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bottom Button pressed", Toast.LENGTH_SHORT).show();
                nextStep(false);
                updateQA();
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("PositionKey", mCurrentPosition);

    }

    private void updateQA(){
        mCurrentQAPair=mQAPairBank[mCurrentPosition];
        mTextViewStory.setText(mCurrentQAPair.getQuestion());
        mButtonTop.setText(mCurrentQAPair.getAnswerTop());
        mButtonBottom.setText(mCurrentQAPair.getAnswerBottom());
    }

    private void nextStep(boolean top){

        switch(mCurrentPosition){
            case 0:
                if (top){
                    mCurrentPosition=2;
                }
                else{
                    mCurrentPosition=1;
                }
                break;
            case 1:
                if (top){
                    mCurrentPosition=2;
                }
                else
                    mCurrentPosition=3;
                break;
            case 2:
                if (top){
                    mCurrentPosition=5;
                }
                else {
                    mCurrentPosition=4;
                }
                break;

        }

    }

}
