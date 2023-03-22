package ru.ms.stu.gamescore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.ms.stu.gamescore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var score1 = -1
    private var score2 = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeScore()
    }

    private fun changeScore() {
        with(binding) {
            src1.setOnClickListener(View.OnClickListener {
                src1.text = (++score1).toString()
            })
            src2.setOnClickListener(View.OnClickListener {
                src2.text = (++score2).toString()
            })
        }
    }
}