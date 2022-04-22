package pinasarap.quiz.app;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class levelActivity extends AppCompatActivity {

    Button easyBtn,mediumBtn,hardBtn;
    MediaPlayer mediaPlayer;
    TextView textView2;
    ImageView imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        InitializeUI();
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(levelActivity.this,RegionActivity.class);
                startActivity(intent);
            }
        });
        textView2.setText("Points : "+MainActivity.prefs.getInt("star",0));

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

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    public void InitializeUI(){
        easyBtn =(Button)findViewById(R.id.easyBtn);
        mediumBtn =(Button)findViewById(R.id.mediumBtn);
        hardBtn = (Button)findViewById(R.id.hardBtn);
        textView2 =(TextView)findViewById(R.id.textView2);
        imageView6 = (ImageView)findViewById(R.id.imageView6);
        mediaPlayer = MediaPlayer.create(this,R.raw.touch_music);
    }
}
