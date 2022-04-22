package pinasarap.quiz.app;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegionActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView textView2;
    ImageView imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regions);
        mediaPlayer = MediaPlayer.create(this,R.raw.touch_music);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView6 = (ImageView)findViewById(R.id.imageView6);
        textView2.setText("Points : "+MainActivity.prefs.getInt("star",0));
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    public void region(View v){
        switch (v.getId()) {
            case R.id.region1:
                MainActivity.editor.putString("regionSelected","region1.json").commit();
                MainActivity.editor.putString("regionName","Region 1").commit();
                Intent Region1 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region1);
                break;
            case R.id.region2:
                MainActivity.editor.putString("regionSelected","region2.json").commit();
                MainActivity.editor.putString("regionName","Region 2").commit();
                Intent Region2 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region2);
                break;
            case R.id.region3:
                MainActivity.editor.putString("regionSelected","region3.json").commit();
                MainActivity.editor.putString("regionName","Region 3").commit();
                Intent Region3 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region3);
                break;
            case R.id.region4a:
                MainActivity.editor.putString("regionSelected","region4a.json").commit();
                MainActivity.editor.putString("regionName","Region 4A").commit();
                Intent Region4a = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region4a);
                break;
            case R.id.region4b:
                MainActivity.editor.putString("regionSelected","region4b.json").commit();
                MainActivity.editor.putString("regionName","Region 4B").commit();
                Intent Region4b = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region4b);
                break;
            case R.id.region5:
                MainActivity.editor.putString("regionSelected","region5.json").commit();
                MainActivity.editor.putString("regionName","Region 6").commit();
                Intent Region5 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region5);
                break;
            case R.id.region6:
                MainActivity.editor.putString("regionSelected","region6.json").commit();
                MainActivity.editor.putString("regionName","Region 7").commit();
                Intent Region6 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region6);
                break;
            case R.id.region7:
                MainActivity.editor.putString("regionSelected","region7.json").commit();
                MainActivity.editor.putString("regionName","Region 8").commit();
                Intent Region7 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region7);
                break;
            case R.id.region8:
                MainActivity.editor.putString("regionSelected","region8.json").commit();
                MainActivity.editor.putString("regionName","Region 9").commit();
                Intent Region8 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region8);
                break;
            case R.id.region9:
                MainActivity.editor.putString("regionSelected","region9.json").commit();
                MainActivity.editor.putString("regionName","Region 10").commit();
                Intent Region9 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region9);
                break;
            case R.id.region10:
                MainActivity.editor.putString("regionSelected","region10.json").commit();
                MainActivity.editor.putString("regionName","Region 11").commit();
                Intent Region10 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region10);
                break;
            case R.id.region11:
                MainActivity.editor.putString("regionSelected","region11.json").commit();
                MainActivity.editor.putString("regionName","Region 12").commit();
                Intent Region11 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region11);
                break;
            case R.id.region12:
                MainActivity.editor.putString("regionSelected","region12.json").commit();
                MainActivity.editor.putString("regionName","Region 13").commit();
                Intent Region12 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region12);
                break;
            case R.id.region13:
                MainActivity.editor.putString("regionSelected","region13.json").commit();
                MainActivity.editor.putString("regionName","Region 13").commit();
                Intent Region13 = new Intent(RegionActivity.this,levelActivity.class);
                mediaPlayer.start();
                startActivity(Region13);
                break;

        }

    }


}
