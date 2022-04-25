package pinasarap.quiz.app;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class levelActivity extends AppCompatActivity {

    Button easyBtn,mediumBtn,hardBtn;
    MediaPlayer mediaPlayer;
    TextView textView2;
    ImageView imageView6;
    String regionAndLevel;
    String regionSelected;
    String finallevelUnlocked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        InitializeUI();
        regionSelected = MainActivity.prefs.getString("regionSelected",null);
        regionAndLevel = regionSelected.replace(".json","");


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
                if(MainActivity.prefs.getInt("level"+regionAndLevel+"Medium",0) == 1){
                    MainActivity.editor.putString("levelSelected","Medium").commit();
                    Intent mediumIntent = new Intent(levelActivity.this,quizActivity.class);
                    mediaPlayer.start();
                    startActivity(mediumIntent);
                }else{
                    Toast.makeText(levelActivity.this, "Lock", Toast.LENGTH_SHORT).show();
                }

            }
        });

        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.prefs.getInt("level"+regionAndLevel+"Hard",0) == 1){
                    MainActivity.editor.putString("levelSelected","Hard").commit();
                    Intent hardIntent = new Intent(levelActivity.this,quizActivity.class);
                    mediaPlayer.start();
                    startActivity(hardIntent);
                }else{
                    Toast.makeText(levelActivity.this, "Lock", Toast.LENGTH_SHORT).show();
                }

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
