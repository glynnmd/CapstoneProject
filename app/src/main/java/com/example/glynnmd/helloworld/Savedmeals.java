package com.example.glynnmd.helloworld;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.glynnmd.helloworld.R.id.mealname;

public class Savedmeals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedmeals);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.inserttext);
        final EditText mealname = (EditText) findViewById(R.id.mealname);
        final EditText savedcarbs = (EditText) findViewById(R.id.savedcarbs);
        final EditText savedfats = (EditText) findViewById(R.id.savedfats);
        final EditText savedproteins = (EditText) findViewById(R.id.savedproteins);
        Button layoutbutton = (Button) findViewById(R.id.savedmealsubmit);
        layoutbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                layout.addView(createNewTextView(mealname.getText().toString(), savedcarbs.getText().toString(), savedfats.getText().toString(), savedproteins.getText().toString()));

            }
        });
        TextView textView = new TextView(this);
        textView.setText("HELLO!");

    }


    private TextView createNewTextView(String text, String text2, String text3, String text4) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("Name : " + text + " Carbs :" + text2 + "g Fats :" + text3 + "g Proteins :" + text4 + "g");
        return textView;
    }

}

