package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.attr.value;
import static android.R.attr.y;

public class Quiz extends AppCompatActivity {

    protected int q2 = 0; //question 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void minus(View v) {

        if (q2 > 0)
            q2--;

        display(R.id.number, q2);
    }

    public void plus(View v) {

        if (q2 < 4)
            q2++;

        display(R.id.number, q2);
    }

    private void display(int id, int value) {
        TextView view = (TextView) findViewById(id);
        view.setText(String.valueOf(value));
    }

    public void radioButtonYes(View view) {

        RadioButton yes = (RadioButton) findViewById(R.id.yes);

        RadioButton no = (RadioButton) findViewById(R.id.no);

        if (yes.isChecked())

            no.setChecked(false);


    }

    public void radioButtonNo(View view) {

        RadioButton yes = (RadioButton) findViewById(R.id.yes);

        RadioButton no = (RadioButton) findViewById(R.id.no);

        if (no.isChecked())
            yes.setChecked(false);

    }

    public void checkAnswers(View view) {

        boolean ans[] = new boolean[4];

        ans[0] = ans1();
        ans[1] = ans2();
        ans[2] = ans3();
        ans[3] = ans4();

        Intent answers = new Intent(this, CheckAnswers.class);

        Bundle b = new Bundle();
        b.putBooleanArray("check", ans);

        answers.putExtras(b);

        startActivity(answers);


    }


    private boolean ans4() {
        EditText text = (EditText) findViewById(R.id.edit_text);

        String value = text.getText().toString();


        if (value.equals("EditText"))
            return true;
        else
            return false;
    }


    private boolean ans3() {

        RadioButton radio = (RadioButton) findViewById(R.id.yes);

        if (radio.isChecked())
            return false;
        else
            return true;

    }

    private boolean ans2() {

        TextView number = (TextView) findViewById(R.id.number);

        if (q2 == 3)

            return true;
        else
            return false;

    }

    private boolean ans1() {

        CheckBox linear = (CheckBox) findViewById(R.id.linear);
        CheckBox side = (CheckBox) findViewById(R.id.side);
        CheckBox relative = (CheckBox) findViewById(R.id.relative);
        CheckBox top = (CheckBox) findViewById(R.id.top);
        CheckBox right = (CheckBox) findViewById(R.id.right);
        CheckBox center = (CheckBox) findViewById(R.id.center);

        if (linear.isChecked() && relative.isChecked() && !side.isChecked() && !top.isChecked() && !right.isChecked() && !center.isChecked())

            return true;

        else
            return false;

    }
}
