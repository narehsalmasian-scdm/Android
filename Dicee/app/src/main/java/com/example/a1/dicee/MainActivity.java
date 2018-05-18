package com.example.a1.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rollBtn;
    ImageView rightDice;
    ImageView leftDice;
    int [] diceArray = {R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        buttonClicked();
    }

    private void findView(){

        rollBtn= (Button)findViewById(R.id.roll);
        rightDice = (ImageView) findViewById(R.id.image_left);
        leftDice = (ImageView) findViewById(R.id.image_right);
    }

    private void buttonClicked() {
        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomNumber = new Random();
                int number = randomNumber.nextInt(6);

                rightDice.setImageResource(diceArray[number]);
                number = randomNumber.nextInt(6);
                leftDice.setImageResource(diceArray[number]);
            }
        });

    }
    }


