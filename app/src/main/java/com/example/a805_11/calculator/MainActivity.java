package com.example.a805_11.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text1, text2;
    TextView result;
    Button button_add, button_sub, button_mul, button_div;

    Button Numbtn[] = new Button[10];
    Integer NumbtnID[] = {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};

    String num1, num2;
    Integer res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        result = findViewById(R.id.result);

        button_add = findViewById(R.id.button_add);
        button_sub = findViewById(R.id.button_sub);
        button_mul = findViewById(R.id.button_mul);
        button_div = findViewById(R.id.button_div);

        for(int i = 0; i < Numbtn.length; i++) {
            Numbtn[i] = findViewById(NumbtnID[i]);
        }

        for(int i = 0; i < Numbtn.length; i++){
            final int index;
            index = i;

            Numbtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(text1.isFocused() == true){
                        num1 = text1.getText().toString() + Numbtn[index].getText().toString();
                        text1.setText(num1);
                    }else if(text2.isFocused() == true){
                        num2 = text2.getText().toString() + Numbtn[index].getText().toString();
                        text2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(), "먼저 텍스트 란을 선택하세요!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = text1.getText().toString();
                num2 = text2.getText().toString();
                res = Integer.parseInt(num1) + Integer.parseInt(num2);
                result.setText("계산 결과 : " + res.toString());
            }
        });

        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = text1.getText().toString();
                num2 = text2.getText().toString();
                res = Integer.parseInt(num1) - Integer.parseInt(num2);
                result.setText("계산 결과 : " + res.toString());
            }
        });

        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = text1.getText().toString();
                num2 = text2.getText().toString();
                res = Integer.parseInt(num1) * Integer.parseInt(num2);
                result.setText("계산 결과 : " + res.toString());
            }
        });

        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = text1.getText().toString();
                num2 = text2.getText().toString();
                res = Integer.parseInt(num1) / Integer.parseInt(num2);
                result.setText("계산 결과 : " + res.toString());
            }
        });
    }
}
