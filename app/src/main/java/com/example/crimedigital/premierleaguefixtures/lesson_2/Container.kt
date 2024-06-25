package com.example.crimedigital.premierleaguefixtures.lesson_2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crimedigital.premierleaguefixtures.R


class Container : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_result)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, MatchListFragment()).commit()


    }

}