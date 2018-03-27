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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
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
    private long carbvalue = 0;
    private long fatsvalue = 0;
    private long proteinsvalue = 0;
    FirebaseDatabase database;
    DatabaseReference test;
    private ListView mListView;
    private ListView mListView2;
    private ListView mListView3;

    private ArrayAdapter adapter;
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;
    private ArrayAdapter adapter4;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        mListView2 = (ListView) findViewById(R.id.listview2);
        mListView3 = (ListView) findViewById(R.id.listview3);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference().child("values");
        test.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<Long, Long> data = (Map<Long, Long>) dataSnapshot.getValue();

                ArrayList<Long> array = new ArrayList<>();
                ArrayList<Long> array2 = new ArrayList<>();
                ArrayList<Long> array3 = new ArrayList<>();
                ArrayList<Long> array4 = new ArrayList<>();

                array4.add(data.get("adjustedcarbs"));
                array.add(data.get("carbs"));

                array4.add(data.get("adjustedfats"));
                array2.add(data.get("fats"));

                array4.add(data.get("adjustedproteins"));
                array3.add(data.get("proteins"));

                adapter = new ArrayAdapter(MainActivity.this, R.layout.listview, array);
                adapter2 = new ArrayAdapter(MainActivity.this, R.layout.listview, array2);
                adapter3 = new ArrayAdapter(MainActivity.this, R.layout.listview, array3);
                adapter4 = new ArrayAdapter(MainActivity.this, R.layout.listview, array4);


                mListView.setAdapter(adapter);
                mListView2.setAdapter(adapter2);
                mListView3.setAdapter(adapter3);

                ProgressBar prog = findViewById(R.id.prog);
                ProgressBar prog2 = findViewById(R.id.prog2);
                ProgressBar prog3 = findViewById(R.id.prog3);

                carbvalue = (long)adapter4.getItem(0) * 100;
                fatsvalue = (long)adapter.getItem(0);
                int m2 = (int) (carbvalue/fatsvalue);
                prog.setProgress(m2);


                carbvalue = (long)adapter4.getItem(1) * 100;
                fatsvalue = (long)adapter2.getItem(0);
                m2 = (int) (carbvalue/fatsvalue);
                prog2.setProgress(m2);

                carbvalue = (long)adapter4.getItem(2) * 100;
                fatsvalue = (long)adapter3.getItem(0);
                m2 = (int) (carbvalue/fatsvalue);
                prog3.setProgress(m2);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        /*
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

*/
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

