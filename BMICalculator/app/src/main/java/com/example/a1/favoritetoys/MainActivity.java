package com.example.a1.favoritetoys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText wieght;
    EditText height;
    TextView result;
    Button calculate;
    Float floatweight;
    Float floatheight;
    Float bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        calculateBMI();
    }

    private void findView(){

        wieght = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.caluclate);
    }

    private void calculateBMI() {
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                String weigtValue = wieght.getText().toString();
                String heightValue = height.getText().toString();

                if (weigtValue != null && !"".equals(weigtValue)) {

                    floatweight = Float.parseFloat(weigtValue);
                }

                if (heightValue != null && !"".equals(heightValue)) {

                    floatheight = Float.parseFloat(heightValue) / 100;
                }

                bmi = floatweight / floatheight * floatheight;
                showBMI(bmi);
            }

        });

    }

    private void showBMI(float bmi){

        String BMILabel = " ";

        if(Float.compare(bmi, 15f) <= 0){
            BMILabel = getString(R.string.severely_underweight);
        }
        else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0 ){

            BMILabel = getString(R.string.severely_underweight);
        }

        else if(Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0 ){

            BMILabel = getString(R.string.underweight);
        }
        else if(Float.compare(bmi, 18.f) > 0 && Float.compare(bmi, 25f) <= 0 ){

            BMILabel = getString(R.string.normal);
        }
        else if(Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0 ){

            BMILabel = getString(R.string.overweight);
        }
        else if(Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0 ){

            BMILabel = getString(R.string.obese_class_i);
        }
        else if(Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40) <= 0 ){

            BMILabel = getString(R.string.obese_class_ii);
        }
        else{
            BMILabel = getString(R.string.obese_class_iii);
        }


        BMILabel += bmi + "\n\n"+ BMILabel;

        result.setText(BMILabel);
    }
}
