package com.example.matt.macros;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;


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

        Button one = (Button) findViewById(R.id.reset);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            @Nullable
            public void onClick(View v) {
                long zero = 0;
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                test = database.getReference("values/adjustedcarbs");
                test.setValue(zero);

                test = database.getReference("values/adjustedfats");
                test.setValue(zero);

                test = database.getReference("values/adjustedproteins");
                test.setValue(zero);


            }
        });

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
                if(fatsvalue != 0) {
                    int m2 = (int) (carbvalue / fatsvalue);
                    prog.setProgress(m2);
                }




                carbvalue = (long)adapter4.getItem(1) * 100;
                fatsvalue = (long)adapter2.getItem(0);
                if(fatsvalue != 0) {
                    int m2 = (int) (carbvalue / fatsvalue);
                    prog2.setProgress(m2);
                }


                carbvalue = (long)adapter4.getItem(2) * 100;
                fatsvalue = (long)adapter3.getItem(0);
                if(fatsvalue != 0) {
                    int m2 = (int) (carbvalue / fatsvalue);
                    prog3.setProgress(m2);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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
                    case R.id.navfood:
                        Intent food = new Intent(MainActivity.this, Food.class);
                        startActivity(food);
                        finish();
                        break;
                }
                return false;
            }
        });


    }



}

