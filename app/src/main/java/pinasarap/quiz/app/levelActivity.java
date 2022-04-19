package pinasarap.quiz.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class levelActivity extends AppCompatActivity {

    Button easyBtn,mediumBtn,hardBtn;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        InitializeUI();

        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.editor.putString("levelSelected","Easy").commit();
                Intent easyIntent = new Intent(levelActivity.this,quizActivity.class);
                mediaPlayer.start();
                startActivity(easyIntent);
            }
        });

        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.editor.putString("levelSelected","Medium").commit();
                Intent mediumIntent = new Intent(levelActivity.this,quizActivity.class);
                mediaPlayer.start();
                startActivity(mediumIntent);
            }
        });

        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.editor.putString("levelSelected","Hard").commit();
                Intent hardIntent = new Intent(levelActivity.this,quizActivity.class);
                mediaPlayer.start();
                startActivity(hardIntent);
            }
        });

    }

    public void InitializeUI(){
        easyBtn =(Button)findViewById(R.id.easyBtn);
        mediumBtn =(Button)findViewById(R.id.mediumBtn);
        hardBtn = (Button)findViewById(R.id.hardBtn);
        mediaPlayer = MediaPlayer.create(this,R.raw.touch_music);
    }
}
