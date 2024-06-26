package com.example.crimedigital.premierleaguefixtures.lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.crimedigital.premierleaguefixtures.R

class ResultTaskNumberOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_1)

        val resultsTextView: TextView = findViewById(R.id.resultsTextView)
        val results = StringBuilder()

        // 1. Создание массива из 10 матчей без задания голов
        val matches = Array(10) {
            TaskNumberOne() // Создание объектов типа TaskNumberOne
        }

        // 2. Установка случайного количества голов в каждом матче
        matches.forEach {
            it.setGoals((0..5).random(), (0..5).random())
        }

        // 3. Вывод всех матчей
        results.append("Все матчи:\n")
        matches.forEach { results.append(it.toString()).append("\n") }

        // 4. Удаление матчей с ничейным результатом
        val nonDrawMatches = matches.filter { it.goalsTeam1 != it.goalsTeam2 }

        // 5. Вывод матчей без ничьих
        results.append("\nМатчи без ничьих:\n")
        nonDrawMatches.forEach { results.append(it.toString()).append("\n") }

        // 6. Нахождение максимального результата в голах и создание множества
        val maxGoalsSet = nonDrawMatches.flatMap { listOf(it.goalsTeam1, it.goalsTeam2) }.toSet()
        val maxGoals = maxGoalsSet.maxOrNull()

        // 7. Вывод максимального результата в голах
        results.append("\nMax goals set:\n")
        maxGoalsSet.forEach { results.append(it).append("\n") }

        // 8. Вывод максимального количества голов
        results.append("\nMax goals: $maxGoals")

        // Установка текста в TextView
        resultsTextView.text = results.toString()
    }
}

class TaskNumberOne (
    var goalsTeam1: Int = 0,
    var goalsTeam2: Int = 0
) {
    // Функция для задания количества голов
    fun setGoals(goalsTeam1: Int, goalsTeam2: Int) {
        this.goalsTeam1 = goalsTeam1
        this.goalsTeam2 = goalsTeam2
    }

    // Функция для получения строки с результатом матча
    override fun toString(): String {
        return "Команда 1: $goalsTeam1 - Команда 2: $goalsTeam2"
    }
}
