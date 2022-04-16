package pinasarap.quiz.app;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
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

public class quizActivity extends AppCompatActivity {


    ArrayList<Question> questionItems;
    int totalQuestion;
    int currentLevel = 1;
    String correctAnswer;
    ImageView questionImage;
    TextView questionText;
    Button ans1,ans2,ans3;

    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        InitializeUI();

            loadAllQuestions(MainActivity.prefs.getString("levelSelected",null),MainActivity.prefs.getString("regionSelected",null));
        setQuestion(currentLevel);

    }

    public void setQuestion(int number){
        Context context = questionImage.getContext();
        int id = context.getResources().getIdentifier(questionItems.get(number).getImage(), "drawable", context.getPackageName());
        questionImage.setImageResource(id);
        questionText.setText(questionItems.get(number).getText());
        ans1.setText(questionItems.get(number).getAns1());
        ans2.setText(questionItems.get(number).getAns2());
        ans3.setText(questionItems.get(number).getAns3());
    }


    public void answer(View v){
        switch (v.getId()) {
            case R.id.ans1:
                if(questionItems.get(currentLevel).getCorrect().equals("A")){
                    score++;
                    MainActivity.editor.putInt("score",score).commit();
                    checkAnswer(ans1.getText().toString());

                }else{
                    wrongAnswer(fAnswer());
                }
                break;
            case R.id.ans2:
                if(questionItems.get(currentLevel).getCorrect().equals("B")){
                    score++;
                    MainActivity.editor.putInt("score",score).commit();
                    checkAnswer(ans2.getText().toString());
                }else{
                    wrongAnswer(fAnswer());
                }
                break;
            case R.id.ans3:
                if(questionItems.get(currentLevel).getCorrect().equals("C")){
                    score++;
                    MainActivity.editor.putInt("score",score).commit();
                    checkAnswer(ans3.getText().toString());
                }else{
                    wrongAnswer(fAnswer());
                }
                break;
        }
    }

    private void checkAnswer(String cAnswer){
            if(totalQuestion != currentLevel){
                showDialog("Correct!",cAnswer);
            }else{
                showDialog("Correct!",cAnswer);
            }
    }

    private void wrongAnswer(String cAnswer){
        showDialog("Wrong!",cAnswer);
    }


    public String fAnswer(){
        if(questionItems.get(currentLevel).getCorrect().equals("A")){
            return questionItems.get(currentLevel).getAns1();
        }else if(questionItems.get(currentLevel).getCorrect().equals("B")){
            return correctAnswer = questionItems.get(currentLevel).getAns2();
        }else if(questionItems.get(currentLevel).getCorrect().equals("C")){
            return correctAnswer = questionItems.get(currentLevel).getAns2();
        }
        return null;
    }


    public void showDialog(String rAns,String caf){
        final Dialog dialog = new Dialog(quizActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.ans_dialog);

TextView resultAns = (TextView) dialog.findViewById(R.id.textView4);
        TextView cAns = (TextView) dialog.findViewById(R.id.textView6);

        resultAns.setText(rAns);
        cAns.setText(caf);


        Button gotoTrivia = (Button) dialog.findViewById(R.id.button8);
        Button skipTrivia = (Button) dialog.findViewById(R.id.button9);

        gotoTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        skipTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalQuestion != currentLevel) {
                    currentLevel++;
                    setQuestion(currentLevel);
                }else{
                    Log.d("status","Wala ng susunod");
                    Intent intent = new Intent(quizActivity.this,RegionComplete.class);
                    startActivity(intent);
                }
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void loadAllQuestions(String level,String region) {
        questionItems = new ArrayList<>();
        String jsonStr = loadJSONFromAssets(region);

        try {
            JSONObject JO = new JSONObject(jsonStr);
            JSONArray lvl = JO.getJSONArray(level);
            for(int i = 0; i < lvl.length(); i++){
                JSONObject getlvl = lvl.getJSONObject(i);
                JSONArray questions = getlvl.getJSONArray("questions");

                for(int q = 0; q < questions.length(); q++){
                    totalQuestion = questions.length() - 1;
                    JSONObject question = questions.getJSONObject(q);
                    String image = question.getString("image");
                    String correct = question.getString("correct");
                    String text = question.getString("text");
                    String ans1 = question.getString("btn1");
                    String ans2 = question.getString("btn2");
                    String ans3 = question.getString("btn3");
                    questionItems.add(new Question(
                            image,
                            correct,
                            text,
                            ans1,
                            ans2,
                            ans3
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
