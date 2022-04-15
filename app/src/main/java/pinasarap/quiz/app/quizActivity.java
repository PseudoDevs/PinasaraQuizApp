package pinasarap.quiz.app;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class quizActivity extends AppCompatActivity {


    ArrayList<Question> questionItems;
    int totalQuestion;
    int currentLevel = 1;

    ImageView questionImage;
    TextView questionText;
    Button ans1,ans2,ans3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        InitializeUI();
        loadAllQuestions(MainActivity.prefs.getString("levelSelected",null),MainActivity.prefs.getString("regionSelected",null));
    }



    private void loadAllQuestions(String level,String region){
        questionItems = new ArrayList<>();
        String jsonStr = loadJSONFromAssets(region);

        try {
            JSONObject JO = new JSONObject(jsonStr);
            JSONArray lvl = JO.getJSONArray(level);
            for(int i = 0; i<lvl.length();i++){
                JSONObject getlvl = lvl.getJSONObject(i);
                JSONArray questions = getlvl.getJSONArray("questions");
                totalQuestion = questions.length() - 1;
                for(int q = 0; q<questions.length();q++){
                    JSONObject question = questions.getJSONObject(q);
                    String image = question.getString("image");
                    String correct = question.getString("correct");
                    questionItems.add(new Question(
                            image,
                            correct
                    ));
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }



    private String loadJSONFromAssets(String file){
        String json ="";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    public void InitializeUI(){
        questionImage = (ImageView) findViewById(R.id.questionImage);
        questionText = (TextView) findViewById(R.id.questionText);
        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
    }
}
