package ru.ms.stu.gamescore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import kotlinx.android.parcel.Parcelize
import ru.ms.stu.gamescore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var state: State

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State (
                score1=0,
                score2=0
              )
        visualization()
        changeScore()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)

    }
    private fun changeScore() {
        with(binding) {
            src1.setOnClickListener(View.OnClickListener {
                ++state.score1
                visualization()
            })
            src2.setOnClickListener(View.OnClickListener {
                ++state.score2
                visualization()
            })
        }
    }
    private fun visualization() {
        with(binding) {
            src1.text = state.score1.toString()
            src2.text = state.score2.toString()
        }
    }
    @Parcelize
    class State (
        var score1:Int,
        var score2 :Int
    ) : Parcelable

    companion object {
        @JvmStatic private val KEY_STATE = "STATE"
    }

}