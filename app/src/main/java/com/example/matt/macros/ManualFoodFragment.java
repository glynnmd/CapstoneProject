package com.example.matt.macros;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Bundle;
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



/**
 * Created by Matt on 3/28/18.
 */

public class ManualFoodFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_food2,container,false);
        Button sub = (Button) view.findViewById(R.id.sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText carbs = (EditText) view.findViewById(R.id.mealcarbs);
                EditText fats = (EditText) view.findViewById(R.id.mealfats);
                EditText proteins = (EditText) view.findViewById(R.id.mealproteins);

                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show();

            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.navigation_home:
                        Intent main = new Intent(view.getContext(), MainActivity.class);
                        startActivity(main);
                        getActivity().finish();
                        break;

                    case R.id.navsaved:
                        Intent save = new Intent(view.getContext(), Savedmeals.class);
                        startActivity(save);
                        getActivity().finish();
                        break;
                    case R.id.navsuggestions:
                        Intent sugg = new Intent(view.getContext(), Suggestions.class);
                        startActivity(sugg);
                        getActivity().finish();
                        break;
                    case R.id.navfood:

                }
                return false;
            }
        });

        return view;

    }

}
