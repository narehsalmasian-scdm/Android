package com.example.a1.tabview;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtFont;
    Button btn0,
            btn1,
            btn2,
            btn3,
            btn4,
            btn5,
            btn6,
            btn7,
            btn8,
            btn9;
    Button btnequal,
            btnsub,
            btndivide,
            btnmult,
            btnPlus,
            btnAc,
            btnC,
            btnsign,
            btndec;

    Animation ZoomIn;

    float num1, num2, result = 0;
    String operation = "";
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        init();
    }

    public void findView() {

        txtFont = (TextView) findViewById(R.id.txtFont);
        btn0 = (Button) findViewById(R.id.zero);
        btn1 = (Button) findViewById(R.id.one);
        btn2 = (Button) findViewById(R.id.two);
        btn3 = (Button) findViewById(R.id.three);
        btn4 = (Button) findViewById(R.id.four);
        btn5 = (Button) findViewById(R.id.five);
        btn6 = (Button) findViewById(R.id.six);
        btn7 = (Button) findViewById(R.id.seven);
        btn8 = (Button) findViewById(R.id.eight);
        btn9 = (Button) findViewById(R.id.nine);
        btnAc = (Button) findViewById(R.id.ac);
        btnC = (Button) findViewById(R.id.c);
        btndec = (Button) findViewById(R.id.decimal);
        btndivide = (Button) findViewById(R.id.div);
        btnequal = (Button) findViewById(R.id.equal);
        btnmult = (Button) findViewById(R.id.mult);
        btnsub = (Button) findViewById(R.id.minus);
        btnPlus = (Button) findViewById(R.id.plus);
        btnsign = (Button) findViewById(R.id.perc);

    }

    private void init() {
        txtFont.setText("0.0");
        ZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        setTextFont();
        setTextSize();
    }

    private void setTextFont() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/HELR45W.ttf");
        btn0.setTypeface(font);
        btn1.setTypeface(font);
        btn2.setTypeface(font);
        btn3.setTypeface(font);
        btn4.setTypeface(font);
        btn5.setTypeface(font);
        btn6.setTypeface(font);
        btn7.setTypeface(font);
        btn8.setTypeface(font);
        btn9.setTypeface(font);
        btnAc.setTypeface(font);
        btnC.setTypeface(font);
        btndec.setTypeface(font);
        btndivide.setTypeface(font);
        btnequal.setTypeface(font);
        btnmult.setTypeface(font);
        btnsub.setTypeface(font);
        btnPlus.setTypeface(font);
        btnsign.setTypeface(font);
        txtFont.setTypeface(font);
    }

    private void setTextSize() {

        int Size = 25;
        btn0.setTextSize(Size);
        btn1.setTextSize(Size);
        btn2.setTextSize(Size);
        btn3.setTextSize(Size);
        btn4.setTextSize(Size);
        btn5.setTextSize(Size);
        btn6.setTextSize(Size);
        btn7.setTextSize(Size);
        btn8.setTextSize(Size);
        btn9.setTextSize(Size);
        btnAc.setTextSize(Size);
        btnC.setTextSize(Size);
        btndec.setTextSize(Size);
        btndivide.setTextSize(Size);
        btnequal.setTextSize(Size);
        btnmult.setTextSize(Size);
        btnsub.setTextSize(Size);
        btnPlus.setTextSize(Size);
        btnsign.setTextSize(Size);
        txtFont.setTextSize((float) (Size * 2.5));
    }

    public void ButtonClick(View v) {
        int id = v.getId();
        if (id == R.id.zero) {
            String str = txtFont.getText().toString().trim();
            if (!str.equalsIgnoreCase("0.0"))
                txtFont.setText(str + "0");
            setNum(0);
        } else if (id == R.id.one)
            setNum(1);
        else if (id == R.id.two)
            setNum(2);
        else if (id == R.id.three)
            setNum(3);
        else if (id == R.id.four)
            setNum(4);
        else if (id == R.id.five)
            setNum(5);
        else if (id == R.id.six)
            setNum(6);
        else if (id == R.id.seven)
            setNum(7);
        else if (id == R.id.eight)
            setNum(8);
        else if (id == R.id.nine)
            setNum(9);
        else if (id == R.id.plus) {

            num1 = Float.parseFloat(txtFont.getText().toString());
            operation = "+";
        } else if (id == R.id.minus) {

            num1 = Float.parseFloat(txtFont.getText().toString());
            operation = "-";
        } else if (id == R.id.mult) {

            num1 = Float.parseFloat(txtFont.getText().toString());
            operation = "x";
        } else if (id == R.id.div) {

            num1 = Float.parseFloat(txtFont.getText().toString());
            operation = "/";
        } else if (id == R.id.equal) {

            num2 = Float.parseFloat(txtFont.getText().toString());
            switch (operation) {

                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            txtFont.setText(result + "");
            num1 = num2 = 0;
            operation = "";
        } else if (id == R.id.ac || id == R.id.c) {

            operation = "";
            num1 = num2 = 0;
            txtFont.setText("0.0");
            flag = false;
        } else if (id == R.id.perc) {

            Float Num = Float.parseFloat(txtFont.getText().toString());
            if (Num != 0)
                txtFont.setText(Num * -1 + "");
        }
    }

    void setNum(int num) {


        String str = txtFont.getText().toString();
        txtFont.startAnimation(ZoomIn);
        if (operation == "") {
            if (str.equalsIgnoreCase("0.0"))
                txtFont.setText((num + ""));
            else
                txtFont.setText((str + num + ""));
        } else {
            if (!flag) {

                txtFont.setText(num + "");
                flag = true;
            } else {

                txtFont.setText(str + num);
            }

        }

    }
}
