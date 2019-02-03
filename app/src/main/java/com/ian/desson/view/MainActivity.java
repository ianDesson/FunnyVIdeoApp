package com.ian.desson.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ian.desson.model.Video;
import com.ian.desson.R;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbReference = FirebaseDatabase.getInstance().getReference();

    }

    public void randomVideoButton(View view) {

    }
}
