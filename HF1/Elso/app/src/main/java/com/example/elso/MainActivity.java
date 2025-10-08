package com.example.elso;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(num1.getText().toString());
                    double b = Double.parseDouble(num2.getText().toString());
                    double res = 0;


                    if (v.getId() == R.id.btnAdd) {
                        res = a + b;
                    } else if (v.getId() == R.id.btnSub) {
                        res = a - b;
                    } else if (v.getId() == R.id.btnMul) {
                        res = a * b;
                    } else if (v.getId() == R.id.btnDiv) {
                        if (b == 0) throw new ArithmeticException("0-val nem lehet osztani!");
                        res = a / b;
                    }

                    result.setText("Eredmény: " + res);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Adj meg érvényes számokat!", Toast.LENGTH_SHORT).show();
                } catch (ArithmeticException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
    }
}