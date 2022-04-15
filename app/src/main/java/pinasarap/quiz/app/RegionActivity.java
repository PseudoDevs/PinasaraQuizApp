package pinasarap.quiz.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regions);

    }

    public void region(View v){

        switch (v.getId()) {
            case R.id.region1:
                MainActivity.editor.putString("regionSelected","region1.json").commit();
                Intent Region1 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region1);
                break;
            case R.id.region2:
                MainActivity.editor.putString("regionSelected","region2.json").commit();
                Intent Region2 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region2);
                break;
            case R.id.region3:
                MainActivity.editor.putString("regionSelected","region3.json").commit();
                Intent Region3 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region3);
                break;
            case R.id.region4:
                MainActivity.editor.putString("regionSelected","region4.json").commit();
                Intent Region4 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region4);
                break;
            case R.id.region5:
                MainActivity.editor.putString("regionSelected","region5.json").commit();
                Intent Region5 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region5);
                break;
            case R.id.region6:
                MainActivity.editor.putString("regionSelected","region6.json").commit();
                Intent Region6 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region6);
                break;
            case R.id.region7:
                MainActivity.editor.putString("regionSelected","region7.json").commit();
                Intent Region7 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region7);
                break;
            case R.id.region8:
                MainActivity.editor.putString("regionSelected","region8.json").commit();
                Intent Region8 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region8);
                break;
            case R.id.region9:
                MainActivity.editor.putString("regionSelected","region9.json").commit();
                Intent Region9 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region9);
                break;
            case R.id.region10:
                MainActivity.editor.putString("regionSelected","region10.json").commit();
                Intent Region10 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region10);
                break;
            case R.id.region11:
                MainActivity.editor.putString("regionSelected","region11.json").commit();
                Intent Region11 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region11);
                break;
            case R.id.region12:
                MainActivity.editor.putString("regionSelected","region12.json").commit();
                Intent Region12 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region12);
                break;
            case R.id.region13:
                MainActivity.editor.putString("regionSelected","region13.json").commit();
                Intent Region13 = new Intent(RegionActivity.this,levelActivity.class);
                startActivity(Region13);
                break;

        }

    }


}
