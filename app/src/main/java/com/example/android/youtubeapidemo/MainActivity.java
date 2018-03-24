package com.example.android.youtubeapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "AIzaSyAfNqv-uNhGN9ZrKNmLtkXNFER2Rcnf0Ww";

    //Youtube Listener
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;

    //Declare View
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerSupportFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player);

        playButton = findViewById(R.id.play_button);

        initPlayer();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                youTubePlayerSupportFragment.initialize(API_KEY,mOnInitializedListener);

            }
        });

    }

    private void initPlayer() {
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("gymcNvVEIJ4");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(MainActivity.this,"Failed To Load Video...",Toast.LENGTH_SHORT).show();
            }
        };
    }
}
