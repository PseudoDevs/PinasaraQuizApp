package pinasarap.quiz.app;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
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
    ImageView imageView6;

    int score = 0;
    MediaPlayer correctMediaPlayer,wrongMediaPlayer;
    TextView textView2;
    int star;
    ImageView startLife1,startLife2,startLife3;
    int starLife = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        InitializeUI();
        MainActivity.editor.putInt("score",0).commit();
        textView2.setText("Points : "+MainActivity.prefs.getInt("star",0));
        star = MainActivity.prefs.getInt("star",0);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(quizActivity.this,levelActivity.class);
                startActivity(intent);
            }
        });

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

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    public void answer(View v){
        switch (v.getId()) {
            case R.id.ans1:
                if(questionItems.get(currentLevel).getCorrect().equals("A")){
                    score++;
                    star++;
                    MainActivity.editor.putInt("star",star).commit();
                    textView2.setText("Points : "+star);
                    correctMediaPlayer.start();
                    MainActivity.editor.putInt("score",score).commit();
                    checkAnswer(ans1.getText().toString());
                }else{
                    starLifes();
                    wrongMediaPlayer.start();
                    wrongAnswer(fAnswer());

                }
                MainActivity.editor.putString("getTrivia",questionItems.get(currentLevel).getTrivia());
                break;
            case R.id.ans2:
                if(questionItems.get(currentLevel).getCorrect().equals("B")){
                    score++;
                    star++;
                    MainActivity.editor.putInt("star",star).commit();
                    textView2.setText("Points : "+star);
                    correctMediaPlayer.start();
                    MainActivity.editor.putInt("score",score).commit();
                    checkAnswer(ans2.getText().toString());
                }else{
                    starLifes();
                    wrongMediaPlayer.start();
                    wrongAnswer(fAnswer());
                }
                MainActivity.editor.putString("getTrivia",questionItems.get(currentLevel).getTrivia());
                break;
            case R.id.ans3:
                if(questionItems.get(currentLevel).getCorrect().equals("C")){
                    score++;
                    star++;
                    MainActivity.editor.putInt("star",star).commit();
                    textView2.setText("Points : "+star);
                    correctMediaPlayer.start();
                    MainActivity.editor.putInt("score",score).commit();
                    checkAnswer(ans3.getText().toString());
                }else{
                    starLifes();
                    wrongMediaPlayer.start();
                    wrongAnswer(fAnswer());
                }
                break;
        }
    }

    public void starLifes(){
        starLife--;
        if(starLife == 2){
            startLife1.setVisibility(View.VISIBLE);
            startLife2.setVisibility(View.VISIBLE);
            startLife3.setVisibility(View.GONE);
        }else if(starLife == 1){
            startLife1.setVisibility(View.VISIBLE);
            startLife2.setVisibility(View.GONE);
            startLife3.setVisibility(View.GONE);
        }else if(starLife == 0){
            startLife1.setVisibility(View.GONE);
            startLife2.setVisibility(View.GONE);
            startLife3.setVisibility(View.GONE);
            Intent intent = new Intent(quizActivity.this,RegionComplete.class);
            startActivity(intent);
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
                showTrivia();
                dialog.dismiss();
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

    public void showTrivia(){
        Dialog dialog=new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.trivia_popup);

        Button close_trivia = (Button)dialog.findViewById(R.id.close_trivia);
        TextView textView3 = (TextView)dialog.findViewById(R.id.textView3);
        textView3.setText(questionItems.get(currentLevel).getTrivia());
        ImageView imageView5 = (ImageView)dialog.findViewById(R.id.imageView5);
        Context context = imageView5.getContext();
        int id = context.getResources().getIdentifier(questionItems.get(currentLevel).getImage(), "drawable", context.getPackageName());
        imageView5.setImageResource(id);

        close_trivia.setOnClickListener(new View.OnClickListener() {
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
                    String trivia = question.getString("trivia");
                    questionItems.add(new Question(
                            image,
                            correct,
                            text,
                            ans1,
                            ans2,
                            ans3,
                            trivia
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
        startLife1 =(ImageView)findViewById(R.id.star_life1);
        startLife2 =(ImageView)findViewById(R.id.star_life2);
        startLife3 =(ImageView)findViewById(R.id.star_life3);
        textView2 =(TextView)findViewById(R.id.textView2);
        imageView6 =(ImageView)findViewById(R.id.imageView6);
        correctMediaPlayer = MediaPlayer.create(this,R.raw.correct_music);
        wrongMediaPlayer = MediaPlayer.create(this,R.raw.wrong_music);
    }
}
