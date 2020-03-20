package com.lermontova.calculatorappfocusstart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editTextView;
    Button button;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        initViews();
    }

    private void initViews() {
        textView = findViewById(R.id.text_view);
        editTextView = findViewById(R.id.edit_text_view);
        button = findViewById(R.id.button_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextView.getText().toString();
                String result = calculator.calculate(input);
                textView.setText(result);
            }
        });
    }
}