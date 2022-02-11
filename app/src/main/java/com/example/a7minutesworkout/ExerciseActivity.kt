package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityExerciseBinding
import com.example.a7minutesworkout.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {

    private var restTimer: CountDownTimer? = null
    private var restprogress = 0
    private var initTime = 10

    private var exerciseTimer: CountDownTimer? = null
    private var exerciseprogress = 0
    private var exerciseTime = 30

    private var binding: ActivityExerciseBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExercise)
        // Back Button 활성화
        if(supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }

        setupRestView()

    }

    private fun setRestProgressBar() {
        binding?.progressBar?.progress = restprogress

        restTimer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restprogress++
                binding?.progressBar?.progress = initTime - restprogress
                binding?.tvTimer?.text = (initTime - restprogress).toString()
            }

            override fun onFinish() {
                setupExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressBar() {
        binding?.progressBarExercise?.progress = exerciseprogress

        exerciseTimer = object: CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseprogress++
                binding?.progressBarExercise?.progress = exerciseTime - exerciseprogress
                binding?.tvTimerExercise?.text = (exerciseTime - exerciseprogress).toString()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "Here now we will start the exercise.",
                    Toast.LENGTH_SHORT
                ).show()
                binding?.flExerciseView?.visibility = View.INVISIBLE
            }
        }.start()
    }

    private fun setupRestView() {
        if(restTimer != null) {
            restTimer?.cancel()
            restprogress = 0
        }

        setRestProgressBar()
    }

    private fun setupExerciseView() {
        binding?.flProgressBar?.visibility = View.INVISIBLE
        binding?.tvTitle?.text = "Exercise Name"
        binding?.flExerciseView?.visibility = View.VISIBLE

        if(exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseprogress = 0
        }

        setExerciseProgressBar()
    }

    override fun onDestroy() {
        super.onDestroy()

        if(restTimer != null) {
            restTimer?.cancel()
            restprogress = 0
        }

        if(exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseprogress = 0
        }

        binding = null
    }

}