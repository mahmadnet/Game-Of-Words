package com.example.ahmad.gow;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.constraint.*;

import org.w3c.dom.Text;

import java.util.*;

public class Level1Activity extends AppCompatActivity {

    String[] wordArray_L5 = { "apple", "behind", "create", "enjoy", "éclair", "letter", "spoke", "speak", "glass", "dirty", "video", "audio", "shift", "funny", "eight", "elite", "four", "movie", "mover", "clock", "class", "study", "brush", "write", "right", "wrong", "wrist", "watch", "eight", "sweet", "solve", "email", "seven", "glide", "hover", "union", "sight", "teeth", "tough", "print", "break", "brake", "apply", "after", "waves", "sound", "light", "force", "speed", "occur", "frame", "crest", "field", "earth", "human", "focus", "quark", "brain", "sport", "equal", "point" };
    String[] wordArray_L7 = { "destroy", "perfume", "jealous", "tuesday", "dislike", "intense", "lullaby", "shotgun", "hostile", "uniform", "whistle", "entered", "arrival", "october", "january", "control", "request", "friends", "physics", "biology", "student", "society", "explain", "inertia", "vibrate", "support", "carrier", "electron", "neutron", "sparrow", "peacock", "disturb", "audible", "digital", "fission", "fashion", "service", "quality", "circuit", "current", "musical", "explain", "average", "product", "medical", "alcohol", "initial", "healthy", "combine", "panther", "natural", "monitor", "speaker", "feeling", "numeric", "problem", "account", "contact", "profile", "filling", "cricket" };
    String[] wordArray_L9 = { "oscillate", "magnitude", "amplitude", "leviathan", "celebrate", "fireboard", "embezzled", "shivering", "universe", "hostility", "enlighten", "alignment", "telescope", "technical", "workspace", "workplace", "principle", "generator", "insulator", "unhealthy", "artificial", "direction", "operation", "destroyer", "passenger", "supporter", "activates", "ambitious", "irritates", "adventure", "terrorist", "interests", "narrators", "irritated", "tolerates", "resonator", "identical", "chocolate", "christmas", "beautiful", "happiness", "wednesday", "challenge", "important", "dangerous", "knowledge", "pollution", "president", "alligator", "secretary", "adjective", "wrestling", "halloween", "seventeen", "affection", "vegetable", "influence", "structure", "different", "invisible", "nutrition" };
    String[] wordArray_L11 = { "information", "destruction", "environment", "explanation", "destruction", "devastation", "declaration", "photography", "preposition", "abomination", "personality", "subtraction", "quadrillion", "alternative", "celebration", "cleanliness", "anniversary", "forgiveness", "belligerent", "imagination", "segregation", "inspiration", "marshmallow", "electricity", "caterpillar", "intelligent", "responsible", "appreciated", "advertising", "destination", "exterminate", "accessories", "complicated", "agriculture", "certificate", "nothingness", "communicate", "defloration", "retribution", "cheerleader", "application", "achievement", "everlasting", "counterfeit", "screwdriver", "evaporation", "perspective", "reservation", "mathematics", "independent", "remembering", "spectacular", "ingredients", "captivating", "emotionless", "pollination", "measurement", "hospitality", "magnificent", "temperature", "pomegranate" };

    int[] RN_Array = new int[6];

    String[] definedWord = new String[1]; //String variable to assign value from  the array.
    String[] userWord = new String[1]; //String variable to take input from the user.
    boolean r = true;
    int[] Score = {0}; //Variable to calculate the Score.
    int Plier=5; //Variable to set a multiplier at every level.
    int count=0;
    int[] index = {0};

    LinearLayout mLayout;
    LinearLayout gameOver;
    LinearLayout timedOut;
    LinearLayout gameComplete;
    EditText eText;
    Button bNext;
    TextView tView;
    TextView tvScore;
    TextView tvTime;

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        countDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTime.setText( (Long.toString( millisUntilFinished / 1000) + "s" ) );
            }

            public void onFinish() {
                Level1Activity.this.setContentView(R.layout.game_timedout);
            }
        };

        mLayout = (LinearLayout)(findViewById(R.id.main_Layout));
        gameOver = (LinearLayout)(findViewById(R.id.game_Over));
        timedOut = (LinearLayout)(findViewById(R.id.timed_Out));
        gameComplete = (LinearLayout)(findViewById(R.id.game_Complete));
        tView = (TextView)(findViewById(R.id.tv_outWord));
        tvScore = (TextView)(findViewById(R.id.tv_scoreNo));
        tvTime = (TextView)(findViewById(R.id.tv_timer));
        eText = (EditText)(findViewById(R.id.et_inWord));
        bNext = (Button) findViewById(R.id.btn_Next);

        //RN_Array = RN_Array_Generator(RN_Array);

        initializeGame();
    }

    public void initializeGame() {

        if (Score[0]==0) {
            RN_Array = RN_Array_Generator(RN_Array);
            index[0] = 0;
            mLayout.setBackgroundColor(getResources().getColor(R.color.grape_primary));
            bNext.setBackgroundColor(getResources().getColor(R.color.grape_light));
            Toast.makeText(this, "Level-1", Toast.LENGTH_SHORT).show();
            countDownTimer.start();
        }
        else if (Score[0]==25) {
            countDownTimer.cancel();
            RN_Array = RN_Array_Generator(RN_Array);
            index[0] = 0;
            mLayout.setBackgroundColor(getResources().getColor(R.color.grass_primary));
            bNext.setBackgroundColor(getResources().getColor(R.color.grass_light));
            Toast.makeText(this, "Level-2", Toast.LENGTH_SHORT).show();
            //
            countDownTimer.start();
        }
        else if(Score[0]==60) {
            countDownTimer.cancel();
            RN_Array = RN_Array_Generator(RN_Array);
            index[0] = 0;
            mLayout.setBackgroundColor(getResources().getColor(R.color.candy_primary));
            bNext.setBackgroundColor(getResources().getColor(R.color.candy_light));
            Toast.makeText(this, "Level-3", Toast.LENGTH_SHORT).show();
            //
            countDownTimer.start();
        }
        else if(Score[0]==105) {
            countDownTimer.cancel();
            RN_Array = RN_Array_Generator(RN_Array);
            index[0] = 0;
            mLayout.setBackgroundColor(getResources().getColor(R.color.dark_primary));
            bNext.setBackgroundColor(getResources().getColor(R.color.dark_light));
            Toast.makeText(this, "Level-4", Toast.LENGTH_SHORT).show();
            //
            countDownTimer.start();
        }

        if ( (Score[0] == 0) || (Score[0] == 5) || (Score[0] == 10) || (Score[0] == 15) || (Score[0] == 20) /*(Score[0] >= 0) && (Score[0] <= 20)*/ ) {
            displayModule(wordArray_L5);
        }
        else if ( (Score[0] == 25) || (Score[0] == 32) || (Score[0] == 39) || (Score[0] == 46) || (Score[0] == 53) /*(Score[0] >= 25) && (Score[0] <= 53)*/ ) {
            displayModule(wordArray_L7);
        }
        else if ( (Score[0] == 60) || (Score[0] == 69) || (Score[0] == 78) || (Score[0] == 87) || (Score[0] == 96) /*(Score[0] >= 60) && (Score[0] <= 96)*/ ) {
            displayModule(wordArray_L9);
        }
        else if ( (Score[0] == 105) || (Score[0] == 116) || (Score[0] == 127) || (Score[0] == 138) || (Score[0] == 149) /*(Score[0] >= 105) && (Score[0] <= 149)*/ ) {
            displayModule(wordArray_L11);
        }

    }

    public void nextW(View view) {

        userWord[0] = eText.getText().toString();

        String uWord = userWord[0];
        String dWord = definedWord[0];

        if ( uWord.contentEquals("") )
            Toast.makeText(this, "Enter Word", Toast.LENGTH_SHORT).show();
        else
            index[0]++;


        if ( (Score[0] == 0) || (Score[0] == 5) || (Score[0] == 10) || (Score[0] == 15) || (Score[0] == 20) /*(Score[0] >= 0) && (Score[0] <= 20)*/ ) {
            xModule( uWord, dWord, 5 );
        }
        else if ( (Score[0] == 25) || (Score[0] == 32) || (Score[0] == 39) || (Score[0] == 46) || (Score[0] == 53) /*(Score[0] >= 25) && (Score[0] <= 53)*/ ) {
            xModule( uWord, dWord, 7 );
        }
        else if ( (Score[0] == 60) || (Score[0] == 69) || (Score[0] == 78) || (Score[0] == 87) || (Score[0] == 96) /*(Score[0] >= 60) && (Score[0] <= 96)*/ ) {
            xModule( uWord, dWord, 9 );
        }
        else if ( (Score[0] == 105) || (Score[0] == 116) || (Score[0] == 127) || (Score[0] == 138) || (Score[0] == 149) /*(Score[0] >= 105) && (Score[0] <= 149)*/ ) {
            xModule( uWord, dWord, 11 );
        }
        //else if (Score[0] == 160)
        //    Toast.makeText(this, "The End.", Toast.LENGTH_SHORT).show();

    }

    public void displayModule( String[] wordArray ) {
        eText.setText("");
        definedWord[0] = wordArray[ RN_Array[ index[0] ] ]; //Assigning the value from wordArray to String definedWord.
        tView.setText(definedWord[0]); //Displaying the word stored in array.
    }

    public void xModule( String uWord, String dWord, int x ) {

        if ( uWord.equalsIgnoreCase(dWord) ) {
            Score[0] += x;
            tvScore.setText( Integer.toString(Score[0]) );

            if ( Score[0] == 160 ) {
                mLayout.setBackgroundColor(getResources().getColor(R.color.grey_900));
                bNext.setBackgroundColor(getResources().getColor(R.color.grey_800));
                eText.setText("");
                eText.setFocusable(false);
                tView.setText("The End");
                Level1Activity.this.setContentView(R.layout.game_complete);
            }
            else
                initializeGame();
        }

        else {
            Level1Activity.this.setContentView(R.layout.game_over);
            //Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
        }
    }

    public int[] RN_Array_Generator(int[] RN_Array) { //Method to generate and return random number.

        Random rmdNo = new Random();

        for(int i=0; i<5; i++) {

            int value;

            boolean found = false;
            do {

                value = rmdNo.nextInt(60);

                for(int j=0; j<5; j++) {

                    if(RN_Array[j]==value) {
                        found = false;
                        break; }
                    else
                        found = true;
                }
            }
            while(found==false);

            RN_Array[i] = value;
        }

        return RN_Array;
    }

    public void backToMain(View view) {
        startActivity(new Intent(Level1Activity.this, MainActivity.class));
    }

}
