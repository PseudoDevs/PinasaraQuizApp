package pinasarap.quiz.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegionComplete extends AppCompatActivity {

    TextView txtScore;
    Button gotoHome, backHome;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_complete);

        txtScore = (TextView) findViewById(R.id.region_overall_score);
        gotoHome = (Button)findViewById(R.id.button10);
        backHome = (Button)findViewById(R.id.button11);
        mediaPlayer = MediaPlayer.create(this,R.raw.touch_music);

            txtScore.setText("Score: " + Integer.toString(MainActivity.prefs.getInt("score",0)) + " / 5");
            gotoHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RegionComplete.this,RegionActivity.class);
                    mediaPlayer.start();
                    startActivity(intent);
                }
            });

            backHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RegionComplete.this,MainActivity.class);
                    mediaPlayer.start();
                    startActivity(intent);

                }
            });
    }
}
