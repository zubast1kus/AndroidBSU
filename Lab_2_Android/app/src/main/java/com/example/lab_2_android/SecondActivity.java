package com.example.lab_2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText((intent.getStringExtra("message")));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editTextNumber);
                String newValue;
                if (editText.getText().toString().equals("")) {
                    newValue = "0";
                }
                else {
                    newValue = editText.getText().toString();
                }
                int confValue = Integer.parseInt(textView.getText().toString()) + Integer.parseInt(newValue);

                Intent newIntent = new Intent(SecondActivity.this, MainActivity.class);
                newIntent.putExtra("result",Integer.toString(confValue));
                setResult(Activity.RESULT_OK, newIntent);
                finish();
            }
        });

    }
}