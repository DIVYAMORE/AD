package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = null;

    }

    public void Music(View view){

        int id = view.getId();
        if(id ==R.id.Play) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.krishna);
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopMusic();
                    }
                });



            }
        }

            else if(id == R.id.Pause){
                if(mediaPlayer!=null) {
                    mediaPlayer.pause();
                }
            }

            else if(id ==R.id.Stop){
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    stopMusic();
                }
            }
        }



    public void stopMusic(){
        mediaPlayer.release();
        mediaPlayer = null;
        Toast.makeText(this, "Media Player released", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}