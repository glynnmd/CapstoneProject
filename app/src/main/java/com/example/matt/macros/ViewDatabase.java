package com.example.matt.macros;

        import android.os.Bundle;
        import android.provider.ContactsContract;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;

/**
 * Created by User on 2/8/2017.
 */

public class ViewDatabase extends AppCompatActivity {
    private static final String TAG = "ViewDatabase";

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private  String userID;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);

        //declare the database reference object. This is what we use to access the database.
        //NOTE: Unless you are signed in, this will not be useable.
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Info uInfo = new Info();
            uInfo.setcarbs(ds.child(userID).getValue(Info.class).getcarbs()); //set the name

            //display all the information
            Log.d(TAG, "showData: name: " + uInfo.getcarbs());


            ArrayList<String> array  = new ArrayList<>();
            array.add(uInfo.getcarbs());
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            mListView.setAdapter(adapter);
        }
    }


    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}