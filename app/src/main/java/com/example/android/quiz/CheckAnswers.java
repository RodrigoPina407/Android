package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.android.quiz.R.drawable.check;
import static com.example.android.quiz.R.id.four;
import static com.example.android.quiz.R.id.one;
import static com.example.android.quiz.R.id.three;
import static com.example.android.quiz.R.id.two;

public class CheckAnswers extends AppCompatActivity {

    private int n_q = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_answers);
        checkAnswers();
    }


    public void checkAnswers() {

        int correct_ans = 0;

        ImageView[] questions = new ImageView[n_q];

        questions[0] = (ImageView) findViewById(R.id.one);
        questions[1] = (ImageView) findViewById(R.id.two);
        questions[2] = (ImageView) findViewById(R.id.three);
        questions[3] = (ImageView) findViewById(R.id.four);


        Bundle bundle = this.getIntent().getExtras();

        boolean[] check = bundle.getBooleanArray("check"); //retrieves the value of each answer

        for (int i = 0; i < n_q; i++) {

            if (check[i]) {
                questions[i].setImageResource(R.drawable.check);
                correct_ans++; //increments for every correct answer
            } else
                questions[i].setImageResource(R.drawable.cross);
        }

        CharSequence text = "You got " + correct_ans + " out of 4 correct answers!";

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

        if (n_q == correct_ans)
            congratulations();
    }

    private void congratulations() {

        ImageView congratz = (ImageView) findViewById(R.id.congrats);

        congratz.setVisibility(View.VISIBLE);

    }

}
