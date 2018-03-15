package com.example.matt.macros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Suggestions extends AppCompatActivity {

    String[] spinnerlist;
    String[] spinnerlist2;

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


                int inttdee = (int) tdee;
                if (text == "Gain Weight") {

                    sugcarb.setText("TDEE " + inttdee);
                    sugfat.setText("Fats: ");
                    sugproteins.setText("Proteins: lit");
                }
                else if (text == "Maintain Weight")
                {

                    sugcarb.setText("MAINTAIN" + inttdee);
                    sugfat.setText("Fats:boy ");
                    sugproteins.setText("Proteins: ");
                }
                else
                {

                    sugcarb.setText("Lose" + inttdee);
                    sugfat.setText("Fats: ");
                    sugproteins.setText("Proteins: Fat ass");
                }

            }
        });






    }

}