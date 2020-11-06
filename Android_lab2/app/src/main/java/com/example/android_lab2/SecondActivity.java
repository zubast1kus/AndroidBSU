package com.example.android_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent newIntent = new Intent(SecondActivity.this, MainActivity.class);
                newIntent.putExtra("message","Введите ответ");
                startActivityForResult(newIntent, 10);
            }

        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = getIntent();
        if (requestCode == 10) {
            if (requestCode == Activity.RESULT_OK) {
                EditText editText = (EditText) findViewById(R.id.editTextNumberSigned);
                TextView textView = (TextView) findViewById(R.id.textView);
                String firstNumb = textView.getText().toString();
                String secondNumb = editText.getText().toString();
                Integer Value = MyService.Sum(firstNumb, secondNumb);
                if (intent.getStringExtra("val") != null){
                    textView.setText(intent.getStringExtra("val"));
                }
            }
        }
        setResult(Activity.RESULT_OK, intent);
    }
}