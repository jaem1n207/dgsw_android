package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editTextNum1, editTextNum2;
    private Button buttonAdd, buttonSub, buttonMul, buttonDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText("Simple Calculator!!");

        editTextNum1=findViewById(R.id.editTextNum1);
        editTextNum2=findViewById(R.id.editTextNum2);

        buttonAdd=findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);

        buttonSub=findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(this);

        buttonMul=findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(this);

        buttonDiv=findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1=0, num2=0, id=v.getId();
        try {
            num1 = Float.parseFloat(editTextNum1.getText().toString());
            num2 = Float.parseFloat(editTextNum2.getText().toString());
        }catch(NumberFormatException e) {
            textView.setText("Invalid Number");
            return;
        }
        if(id == R.id.buttonAdd) {
            num1 += num2;
        } else if(id == R.id.buttonSub) {
            num1 -= num2;
        } else if(id == R.id.buttonMul) {
            num1 *= num2;
        } else if(id == R.id.buttonDiv) {
            if(num2 == 0) {
                textView.setText("Divided by zero");
                return;
            } else {
                num1 /= num2;
            }
        }
        textView.setText(String.valueOf(num1));
    }
}
