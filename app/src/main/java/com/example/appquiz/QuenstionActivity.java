package com.example.appquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class QuenstionActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "What is the correct syntax of the declaration which defines the XML version?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "What is a correct syntax to output Hello World in C#?",
            "Which of these access specifiers can be used for an interface?",
            "What does SQL stand for?",
            "What is the return type of Constructors?",
            "How do you insert COMMENTS in Python code?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "PHP server scripts are surrounded by delimiters, which?"
    };
    String answers[] = {"main method","<?xml version=1.0?>","this","Console.WriteLine(\"Hello World\")","public","Structured query language","None of the mentioned","#This is a  comment","equals()","<?php…?>"};
    String opt[] = {
            "finalize method","main method","static method","private method",
            "<?xml version=1.0?>","<xml version=1.0 />","<?xml version=1.0 />","<xml version=1.0 ?>",
            "import","this","catch","abstract",
            "Console.WriteLine(\"Hello World\")","print (\"Hello World\")","cout << Hello World","System.out.println(\"Hello World\")",
            "public","protected","private","All of the mentioned",
            "Structured question language","Strong question language","Structured query language","Strong query language",
            "int","float","void","None of the mentioned",
            "#This is a  comment","/*This is a  comment*/","//This is a  comment","<!--This is a  comment-->",
            "equals()","Equals()","isequal()","Isequal()",
            "<?php>…<?>","<&>…<&>","<script>…</script>","<?php…?>"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quenstion);
        final TextView score = findViewById(R.id.textView4);
        TextView textView=findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton=findViewById(R.id.button3);
        quitbutton=findViewById(R.id.buttonquit);
        tv= findViewById(R.id.tvque);

        radio_g=findViewById(R.id.answersgrp);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });

    }
}
