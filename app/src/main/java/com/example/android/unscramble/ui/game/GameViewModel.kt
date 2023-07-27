package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private fun getNextWord() {
//        val random = Random.nextInt(allWordsList.size)
//        var currentWord = allWordsList[random]
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while(String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        if(wordList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordList.add(currentWord)
        }
    }

    init {
        Log.d("Game Fragment", "GameViewModel created")
        getNextWord()
    }

    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    private var _score = 0
    val score: Int
        get() = _score

    private var currentWordCount = 0
    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d("Game Fragment", "GameViewModel destroyed")
    }
}