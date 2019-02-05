package com.ian.desson.view;

import java.util.ArrayList;
import java.util.Random;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ian.desson.R;
import com.ian.desson.YoutubeConfig;
import com.ian.desson.model.Video;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.android.youtube.player.YouTubeBaseActivity;

public class MainActivity extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;
    OnInitializedListener onInitializedListener;
    private DatabaseReference dbReference;
    private Video randomVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbReference = FirebaseDatabase.getInstance().getReference();
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);

        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Random r = new Random();
                int randomIndex = r.nextInt();

                ArrayList<Video> videos = new ArrayList<>();
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    videos.add((Video) postSnapShot.getValue());
                }
                randomVideo = videos.get(randomIndex);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        onInitializedListener = new OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(randomVideo.getVideoId());
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };


    }

    public void randomVideoButton(View view) {
        youTubePlayerView.initialize(YoutubeConfig.getApiKey(), onInitializedListener);
    }
}
