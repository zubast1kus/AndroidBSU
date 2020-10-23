package by.bsu.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val numberMassage = intent.getStringExtra(EXTRA_NUMBER)
        val textView = findViewById<TextView>(R.id.textNumbView).apply {
            text = numberMassage
        }

        val editText = findViewById<EditText>(R.id.editTextNumb)

        var score = numberMassage.toInt()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val massage = editText.text.toString()
            if (massage == "")
            {
                Toast.makeText(applicationContext, "Please, enter the number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else
            {
                score += massage.toInt()
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra(EXTRA_NUMBER, score.toString())
                }
                startActivity(intent)
            }
        }
    }

}
