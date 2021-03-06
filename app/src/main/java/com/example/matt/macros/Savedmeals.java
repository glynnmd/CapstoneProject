package com.example.matt.macros;

        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.design.widget.BottomNavigationView;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;


public class Savedmeals extends AppCompatActivity {

    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedmeals);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.inserttext);


        Button layoutbutton = (Button) findViewById(R.id.savedmealsubmit);
        layoutbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText mealname = (EditText) findViewById(R.id.mealname);
                EditText savedcarbs = (EditText) findViewById(R.id.savedcarbs);
                EditText savedfats = (EditText) findViewById(R.id.savedfats);
                EditText savedproteins = (EditText) findViewById(R.id.savedproteins);


                if((mealname.getText().length() >= 1 && savedcarbs.getText().length() >= 1
                        && savedfats.getText().length() >= 1 && savedproteins.getText().length() >= 1)) {
                    database = FirebaseDatabase.getInstance();
                    long savc = Long.parseLong(savedcarbs.getText().toString());
                    long savf = Long.parseLong(savedfats.getText().toString());
                    long savp = Long.parseLong(savedproteins.getText().toString());

                    DatabaseReference test = database.getReference("food/" + mealname.getText().toString());
                    test.setValue(mealname.getText().toString());

                    test = database.getReference("food/" + mealname.getText().toString() + "/carbs");
                    test.setValue(savc);

                    test = database.getReference("food/" + mealname.getText().toString() + "/fats");
                    test.setValue(savf);

                    test = database.getReference("food/" + mealname.getText().toString() + "/proteins");
                    test.setValue(savp);

                    Context context = getApplicationContext();
                    String toaststring = "Submitted!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, toaststring, duration);
                    toast.show();
                }
                else
                {
                    Context context = getApplicationContext();
                    String toaststring = "Complete Fields!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, toaststring, duration);
                    toast.show();
                }


            }
        });
        TextView textView = new TextView(this);
        textView.setText("");


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.navigation_home:
                        Intent home = new Intent(Savedmeals.this, MainActivity.class);
                        startActivity(home);
                        finish();
                        break;
                    case R.id.navsaved:

                    case R.id.navsuggestions:
                        Intent sugg = new Intent(Savedmeals.this, Suggestions.class);
                        startActivity(sugg);
                        finish();
                        break;
                    case R.id.navfood:
                        Intent food = new Intent(Savedmeals.this, Food.class);
                        startActivity(food);
                        finish();
                        break;
                }
                return false;
            }
        });

    }

}