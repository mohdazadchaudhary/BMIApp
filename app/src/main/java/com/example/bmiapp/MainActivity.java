package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtHeightFt, edtHeightInch, edtWeight;
        Button btn1;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.editweight);
        edtHeightFt = findViewById(R.id.editHeightFt);
        edtHeightInch = findViewById(R.id.editHeightInch);
        txtResult = findViewById(R.id.result);
        btn1 = findViewById(R.id.btn1);
        llMain = findViewById(R.id.llMain);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightInch.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.35;
                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);

                if (bmi >25) {
                    txtResult.setText("You are overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi < 18) {
                    txtResult.setText("You are underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    txtResult.setText("You are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        // This line properly closes the onClickListener
        });
    }
}
