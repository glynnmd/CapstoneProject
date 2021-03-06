package com.example.matt.macros;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


/**
 * Created by Matt on 3/28/18.
 */

public class ManualFoodFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";
    FirebaseDatabase database;
    DatabaseReference test;
    int carbvalue;
    int fatsvalue;
    int proteinsvalue;
    long c;
    long f;
    long p;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food2,container,false);
        Button sub = (Button) view.findViewById(R.id.sub);



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText carbs = (EditText) getView().findViewById(R.id.mealcarbs);
                EditText fats = (EditText) getView().findViewById(R.id.mealfats);
                EditText proteins = (EditText) getView().findViewById(R.id.mealproteins);
                if(carbs.length() > 0 && fats.length() > 0 && proteins.length() > 0) {
                    carbvalue = Integer.parseInt(carbs.getText().toString());
                    fatsvalue = Integer.parseInt(fats.getText().toString());
                    proteinsvalue = Integer.parseInt(proteins.getText().toString());


                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    test = database.getReference().child("values");
                    test.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Map<Long, Long> data = (Map<Long, Long>) dataSnapshot.getValue();
                            c = data.get("adjustedcarbs");
                            f = data.get("adjustedfats");
                            p = data.get("adjustedproteins");
                            setCarbvalue(c, f, p);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                    Toast.makeText(getActivity(), "Submitted!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Complete all fields!", Toast.LENGTH_SHORT).show();

                }

            }
        });



        return view;

    }

    public void setCarbvalue(long c, long f, long p)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference("values/adjustedcarbs");
        test.setValue(carbvalue + c);

        test = database.getReference("values/adjustedfats");
        test.setValue(fatsvalue + f);

        test = database.getReference("values/adjustedproteins");
        test.setValue(proteinsvalue + p);

    }

}
