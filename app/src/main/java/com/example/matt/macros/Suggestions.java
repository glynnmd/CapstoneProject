package com.example.matt.macros;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Suggestions extends AppCompatActivity {

    String[] spinnerlist;
    String[] spinnerlist2;
    FirebaseDatabase database;
    DatabaseReference test;


    {
        spinnerlist = new String[]{"Gain Weight", "Maintain Weight", "Lose Weight"};
    }

    {
        spinnerlist2 = new String[]{"Sedentary", "Light activity", "Moderate activity", "Very active"};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,spinnerlist);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,spinnerlist2);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.myspinner);
        final Spinner spinner2 = (Spinner) findViewById(R.id.myspinner2);

        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter2);


        Button suggestions = (Button) findViewById(R.id.suggestionsubmit);
        suggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = spinner.getSelectedItem().toString();
                String text2 = spinner2.getSelectedItem().toString();

                TextView sugcarb = (TextView) findViewById(R.id.sugcarb);
                TextView sugfat = (TextView) findViewById(R.id.sugfat);
                TextView sugproteins = (TextView) findViewById(R.id.sugproteins);

                EditText height = (EditText) findViewById(R.id.heightinput);
                EditText weight = (EditText) findViewById(R.id.weightinput);
                EditText age = (EditText) findViewById(R.id.ageinput);

                double estHeight = 6.25 * Integer.parseInt(height.getText().toString()) * 2.54;
                double estWeight = 10 * (Integer.parseInt(weight.getText().toString()) * 0.453592);
                double estAge = 5 * Integer.parseInt(age.getText().toString());


                double tdee = estHeight + estWeight - estAge;
                if (text2 == "Sedentary")
                {
                    tdee = (int) tdee * 1.2;
                }
                else if (text2 == "Light activity")
                {
                    tdee = (int) tdee * 1.375;
                }
                else if (text2 == "Moderate activity")
                {
                    tdee = (int) tdee * 1.55;
                }
                else
                {
                    tdee = (int) tdee * 1.725;
                }

                if (text == "Lose Weight")
                {
                    tdee = (int) tdee * .8;
                }
                else if (text == "Maintain Weight")
                {
                    tdee = (int) tdee * 1;
                }
                else if (text == "Gain Weight")
                {
                    tdee = (int) tdee * 1.2;
                }


                int inttdee = (int) tdee;
                int pro = (int) (Integer.parseInt(weight.getText().toString()) * .8);
                int fat = inttdee / (4*9);
                int carb = inttdee - (pro * 4) - (fat * 9);
                carb = carb / 4;

                FirebaseDatabase database = FirebaseDatabase.getInstance();

                if (text == "Gain Weight") {
                    sugcarb.setText("Carbs: " + carb);
                    sugfat.setText("Fats: " + fat);
                    sugproteins.setText("Proteins: " + pro);
                    test = database.getReference("values/carbs");
                    test.setValue(carb);

                    test = database.getReference("values/fats");
                    test.setValue(fat);

                    test = database.getReference("values/proteins");
                    test.setValue(pro);

                    test = database.getReference("values/adjustedcarbs");
                    test.setValue(carb);

                    test = database.getReference("values/adjustedfats");
                    test.setValue(fat);

                    test = database.getReference("values/adjustedproteins");
                    test.setValue(pro);

                }
                else if (text == "Maintain Weight")
                {
                    sugcarb.setText("Carbs: " + carb);
                    sugfat.setText("Fats: " + fat);
                    sugproteins.setText("Proteins: " + pro);

                    test = database.getReference("values/carbs");
                    test.setValue(carb);

                    test = database.getReference("values/fats");
                    test.setValue(fat);

                    test = database.getReference("values/proteins");
                    test.setValue(pro);

                    test = database.getReference("values/adjustedcarbs");
                    test.setValue(carb);

                    test = database.getReference("values/adjustedfats");
                    test.setValue(fat);

                    test = database.getReference("values/adjustedproteins");
                    test.setValue(pro);
                }
                else
                {
                    sugcarb.setText("Carbs: " + carb);
                    sugfat.setText("Fats: " + fat);
                    sugproteins.setText("Proteins: " + pro);

                    test = database.getReference("values/carbs");
                    test.setValue(carb);

                    test = database.getReference("values/fats");
                    test.setValue(fat);

                    test = database.getReference("values/proteins");
                    test.setValue(pro);

                    test = database.getReference("values/adjustedcarbs");
                    test.setValue(carb);

                    test = database.getReference("values/adjustedfats");
                    test.setValue(fat);

                    test = database.getReference("values/adjustedproteins");
                    test.setValue(pro);
                }
                Context context = getApplicationContext();
                String toaststring = "Submitted!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, toaststring, duration);
                toast.show();

            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.navigation_home:
                        Intent home = new Intent(Suggestions.this, MainActivity.class);
                        startActivity(home);
                        finish();
                        break;
                    case R.id.navsaved:
                        Intent sugg = new Intent(Suggestions.this, Savedmeals.class);
                        startActivity(sugg);
                        finish();
                        break;
                    case R.id.navsuggestions:

                }
                return false;
            }
        });






    }

}