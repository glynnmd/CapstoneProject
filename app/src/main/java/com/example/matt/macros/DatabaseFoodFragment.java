package com.example.matt.macros;

import android.app.Fragment;
import android.content.Intent;
import android.provider.ContactsContract;
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
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Matt on 3/28/18.
 */

public class DatabaseFoodFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";
    FirebaseDatabase database;
    DatabaseReference test;
    ListView list;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food,container,false);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference().child("food");
        list = (ListView) view.findViewById(R.id.data_list);
        adapter = new ArrayAdapter<String>(getContext(), R.layout.fragment_food, arrayList);

        test.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    String s = ds.getKey();
                    Map<Long, Long> data = (Map<Long, Long>) ds.getValue();
                    arrayList.add(ds.getKey() + data.get("carbs"));



                }
                //Info food = new Info();
                //String s = dataSnapshot.getValue().toString();
                //test = test.child(dataSnapshot.getKey());

                /*Map<Long, Long> data = (Map<Long, Long>) dataSnapshot.child(dataSnapshot.getKey()).getValue();
                food.setFoodcarbs(4);
                food.setFoodfats(4);
                food.setFoodproteins(4);*/

                //arrayList.add(s);

                adapter.notifyDataSetChanged();
                list.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });








        return view;
    }

}
