package com.example.matt.macros;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


/**
 * Created by Matt on 3/28/18.
 */

public class DatabaseFoodFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";
    FirebaseDatabase database;
    DatabaseReference test;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food,container,false);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference().child("food");
        test.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<Long, Long> data = (Map<Long, Long>) dataSnapshot.getValue();
                ListView list = (ListView) getView().findViewById(R.id.list);
                Info yeet[];

                ArrayAdapter<Info> info = new ArrayAdapter<Info>(this, R.layout.fragment_food, yeet);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return view;
    }

}
