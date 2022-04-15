package pinasarap.quiz.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button playBtn,insBtn;
    public static SharedPreferences.Editor editor;
    public static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        editor = getSharedPreferences("StoringData", MODE_PRIVATE).edit();
        prefs = getSharedPreferences("StoringData", MODE_PRIVATE);
        initializeUI();

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegionActivity.class);
                startActivity(intent);
            }
        });
    }



    public void initializeUI(){
        playBtn = (Button) findViewById(R.id.playBtn);
        insBtn = (Button) findViewById(R.id.insBtn);
    }
}