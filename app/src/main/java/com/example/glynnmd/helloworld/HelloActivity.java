package com.example.glynnmd.helloworld;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HelloActivity extends Activity {

    private Button pointless;
    private int carbvalue;
    private int fatsvalue;
    private int proteinsvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        Button sub = (Button) findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText carbs = (EditText) findViewById(R.id.carbs);
                EditText fats = (EditText) findViewById(R.id.fats);
                EditText proteins = (EditText) findViewById(R.id.proteins);
                TextView currentmacros = (TextView) findViewById(R.id.currentmacros);
                TextView calories = (TextView) findViewById(R.id.calories);
                currentmacros.setText("Carbs : " + Integer.parseInt(carbs.getText().toString()) + "  Fats : "
                        + Integer.parseInt(fats.getText().toString()) + "  Proteins : " + Integer.parseInt(proteins.getText().toString()));
                int cal = (Integer.parseInt(proteins.getText().toString()) * 4) + (Integer.parseInt(fats.getText().toString()) * 9) + (Integer.parseInt(carbs.getText().toString()) * 4)
;                calories.setText("Calories :" + cal);
                carbvalue = Integer.parseInt(carbs.getText().toString());
                fatsvalue = Integer.parseInt(fats.getText().toString());
                proteinsvalue = Integer.parseInt(proteins.getText().toString());
            }
        });

        Button sub2 = (Button) findViewById(R.id.sub2);
        sub2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText mealcarbs = (EditText) findViewById(R.id.mealcarbs);
                EditText mealfats = (EditText) findViewById(R.id.mealfats);
                EditText mealproteins = (EditText) findViewById(R.id.mealproteins);
                TextView macrosleft = (TextView) findViewById(R.id.macrosleft);

                    int carbl = carbvalue - Integer.parseInt(mealcarbs.getText().toString());
                    int fatsl = fatsvalue - Integer.parseInt(mealfats.getText().toString());
                    int proteinsl = proteinsvalue - Integer.parseInt(mealproteins.getText().toString());
                    carbvalue = carbl;
                    fatsvalue = fatsl;
                    proteinsvalue = proteinsl;

                    macrosleft.setText("Carbs : " + carbl + " Fats : " +
                            fatsl + " Proteins : " + proteinsl);

            }
        });

        Button savedmeals = (Button) findViewById(R.id.savemeals);
        savedmeals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloActivity.this, Savedmeals.class));
            }
        });    }
}
