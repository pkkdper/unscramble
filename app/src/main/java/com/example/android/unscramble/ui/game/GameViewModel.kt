package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel : ViewModel() {
    init {
        Log.d("Game Fragment", "GameViewModel created")
    }
    private var _score = 0
    private var _currentWordCount = 0
    private var _currentScrambledWord = "test"
    val score: Int
        get() = _score
    val currentScrambledWord: String
        get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d("Game Fragment", "GameViewModel destroyed")
    }

    fun getNextWord() {
//        val random = Random.nextInt(allWordsList.size)
//        var currentWord = allWordsList[random]
        var currentWord = allWordsList.random()
    }
}