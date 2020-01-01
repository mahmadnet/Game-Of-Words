package com.example.ahmad.gow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.constraint.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {

        startActivity(new Intent(MainActivity.this, Level1Activity.class));
    }

    /*public void startGame(View view) {
        Intent intent = new Intent(this, Level1Activity.class);
        *//*
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        *//*
        startActivity(intent);
    }*/

}
