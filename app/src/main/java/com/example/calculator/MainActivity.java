package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText num1EditText;
    private EditText num2EditText;
    private RadioGroup operatorRadioGroup;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        operatorRadioGroup = findViewById(R.id.operatorRadioGroup);
        resultTextView = findViewById(R.id.resultTextView);

        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(num1EditText.getText().toString());
                double num2 = Double.parseDouble(num2EditText.getText().toString());
                double result = 0;

                int selectedOperatorId = operatorRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedOperator = findViewById(selectedOperatorId);
                String operator = selectedOperator.getText().toString();

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            resultTextView.setText("Cannot divide by zero");
                            return;
                        }
                        break;
                    case "%":
                        result = num1 % num2;
                        break;
                }

                resultTextView.setText("Result: " + result);
            }
        });
    }
}
