package pinasarap.quiz.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InstructionsActivity extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Button backToHome;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);

        backToHome = findViewById(R.id.back_to_home);

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InstructionsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
