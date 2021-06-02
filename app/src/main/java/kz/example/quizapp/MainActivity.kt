package kz.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.example.quizapp.fragments.question.QuestionFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = QuestionFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, fragment)
            .commit()
    }
}