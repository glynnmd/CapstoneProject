package com.example.matt.macros;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private Button pointless;
    private int carbvalue = 0;
    private int fatsvalue = 0;
    private int proteinsvalue = 0;
    FirebaseDatabase database;
    DatabaseReference test;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference().child("values");
        test.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<Long, Long> data = (Map<Long, Long>) dataSnapshot.getValue();
                Toast.makeText(getApplicationContext(), "LIT + " + data.get("adjustedcarbs"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Button sub;
        sub = (Button) findViewById(R.id.sub);
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

                int cal = (Integer.parseInt(proteins.getText().toString()) * 4) + (Integer.parseInt(fats.getText().toString()) * 9) + (Integer.parseInt(carbs.getText().toString()) * 4);
                calories.setText("Calories :" + cal);

                carbvalue = Integer.parseInt(carbs.getText().toString());
                fatsvalue = Integer.parseInt(fats.getText().toString());
                proteinsvalue = Integer.parseInt(proteins.getText().toString());

                FirebaseDatabase database = FirebaseDatabase.getInstance();

                test = database.getReference("values/carbs");
                test.setValue(carbvalue);

                test = database.getReference("values/fats");
                test.setValue(fatsvalue);

                test = database.getReference("values/proteins");
                test.setValue(proteinsvalue);
                //onSaveInstanceState(savedInstanceState);
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


/*
        Button savedmeals = (Button) findViewById(R.id.savemeals);
        savedmeals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Savedmeals.class));
            }
        });
        Button sugge = (Button) findViewById(R.id.suggestions);
        sugge.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Suggestions.class));
            }
        });
*/
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.navigation_home:

                    case R.id.navsaved:
                        Intent save = new Intent(MainActivity.this, Savedmeals.class);
                        startActivity(save);
                        finish();
                        break;
                    case R.id.navsuggestions:
                        Intent sugg = new Intent(MainActivity.this, Suggestions.class);
                        startActivity(sugg);
                        finish();
                        break;
                }
                return false;
            }
        });


        //
        //Button suggestions = (Button) findViewById(R.id.suggestions);
        //savedmeals.setOnClickListener(new View.OnClickListener() {
        //@SuppressLint("SetTextI18n")
        //@Override
        //public void onClick(View v) {
        //startActivity(new Intent(HelloActivity.this, Suggestions.class));
        //}
        //});
        //onRestoreInstanceState(savedInstanceState);

    }






}

