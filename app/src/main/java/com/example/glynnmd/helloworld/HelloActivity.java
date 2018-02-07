package com.example.glynnmd.helloworld;

import android.app.Activity;
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
            @Override
            public void onClick(View v) {
                EditText carbs = (EditText) findViewById(R.id.carbs);
                EditText fats = (EditText) findViewById(R.id.fats);
                EditText proteins = (EditText) findViewById(R.id.proteins);
                TextView currentmacros = (TextView) findViewById(R.id.currentmacros);
                currentmacros.setText("Carbs :" + carbs.getText().toString() + "\n Fats : " +
                fats.getText().toString() + "\n Proteins : " + proteins.getText().toString());
                carbvalue = Integer.parseInt(carbs.getText().toString());
                fatsvalue = Integer.parseInt(fats.getText().toString());
                proteinsvalue = Integer.parseInt(proteins.getText().toString());
            }
        });

        Button sub2 = (Button) findViewById(R.id.sub2);
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mealcarbs = (EditText) findViewById(R.id.mealcarbs);
                EditText mealfats = (EditText) findViewById(R.id.mealfats);
                EditText mealproteins = (EditText) findViewById(R.id.mealproteins);
                TextView macrosleft = (TextView) findViewById(R.id.macrosleft);
                if(carbvalue != null && fatsvalue != null && proteinsvalue != null) {
                    int carbl = carbvalue - Integer.parseInt(mealcarbs.getText().toString());
                    int fatsl = fatsvalue - Integer.parseInt(mealfats.getText().toString());
                    int proteinsl = proteinsvalue - Integer.parseInt(mealproteins.getText().toString());

                    macrosleft.setText("Carbs left:" + carbl + "\n Fats : " +
                            fatsl + "\n Proteins : " + proteinsl);
                }
            }
        });
    }
}
