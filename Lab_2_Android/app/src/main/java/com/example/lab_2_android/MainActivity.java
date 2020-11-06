package com.example.lab_2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
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
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message",Integer.toString(confValue));
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText((data.getStringExtra("result")));
            }
        }
    }

}
