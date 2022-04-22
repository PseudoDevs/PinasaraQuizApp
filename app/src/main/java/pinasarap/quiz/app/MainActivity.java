package pinasarap.quiz.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button playBtn,insBtn;
    public static SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    public static Intent musicBG;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        editor = getSharedPreferences("StoringData", MODE_PRIVATE).edit();
        prefs = getSharedPreferences("StoringData", MODE_PRIVATE);
        musicBG = new Intent(MainActivity.this, musicBg.class);
        startService(musicBG);

        initializeUI();

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegionActivity.class);
                mediaPlayer.start();
                startActivity(intent);
            }
        });

        insBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InstructionsActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    public void initializeUI(){
        playBtn = (Button) findViewById(R.id.playBtn);
        insBtn = (Button) findViewById(R.id.insBtn);
        mediaPlayer = MediaPlayer.create(this,R.raw.touch_music);
    }
}