package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText editText;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button gomb = findViewById(R.id.button);
        tv = findViewById(R.id.cimke);
        TextView editText= findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);

        // Második activity indítása
        gomb.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(myIntent);
        });

        // TextView kattintás
        tv.setOnClickListener(v -> tv.append("\n" + tv.getText()));

        Log.d("Status:", "MainActivity:onCreate");


        if (savedInstanceState != null) {
            tv.setText(savedInstanceState.getString("cimke", ""));
            editText.setText(savedInstanceState.getString("editTextValue", ""));
            checkBox.setChecked(savedInstanceState.getBoolean("checkBoxState", false));
            Log.d("Status:", "MainActivity:onCreate – állapot visszaállítva");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putString("cimke", tv.getText().toString());
        outState.putString("editTextValue", editText.getText().toString());
        outState.putBoolean("checkBoxState", checkBox.isChecked());

        Log.d("Status:", "MainActivity:onSaveInstanceState – állapot mentve");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        tv.setText(savedInstanceState.getString("cimke", ""));
        editText.setText(savedInstanceState.getString("editTextValue", ""));
        checkBox.setChecked(savedInstanceState.getBoolean("checkBoxState", false));

        Log.d("Status:", "MainActivity:onRestoreInstanceState – állapot visszaállítva");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status:", "MainActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status:", "MainActivity:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status:", "MainActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status:", "MainActivity:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status:", "MainActivity:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status:", "MainActivity:onDestroy");
    }
}
