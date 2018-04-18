package com.example.matt.macros;

import android.app.Fragment;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
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
    private ArrayList<Info> arrayList = new ArrayList<>();
    private ArrayAdapter<Info> adapter;
    private RecyclerView recyclerView;
    List<Info> testlist;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.drawerlist);
        Info tester = new Info("YOO", 20,20,20);
        Info tester2 = new Info("TESTER2", 50,10,70);
        testlist = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference().child("food");
        test.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Info info = new Info();
                    info.setName(ds.getKey());
                    Map<Long, Long> data = (Map<Long, Long>) ds.getValue();
                    info.setFoodcarbs(data.get("carbs"));
                    info.setFoodfats(data.get("fats"));
                    info.setFoodproteins(data.get("proteins"));
                    testlist.add(info);



                }
                //Info food = new Info();
                //String s = dataSnapshot.getValue().toString();
                //test = test.child(dataSnapshot.getKey());

                Map<Long, Long> data = (Map<Long, Long>) dataSnapshot.child(dataSnapshot.getKey()).getValue();


                //arrayList.add(s);

                //list.setAdapter(adapter);
                //recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        com.example.matt.macros.ListAdapter listAdapter = new com.example.matt.macros.ListAdapter(testlist);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);




        return view;
    }

}
