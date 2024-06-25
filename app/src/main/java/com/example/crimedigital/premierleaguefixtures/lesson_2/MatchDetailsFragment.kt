package com.example.crimedigital.premierleaguefixtures.lesson_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.crimedigital.premierleaguefixtures.R
import com.example.crimedigital.premierleaguefixtures.databinding.FragmentMatchDetailsBinding


class MatchDetailsFragment : Fragment() {


    private lateinit var binding: FragmentMatchDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMatchDetailsBinding.inflate(inflater, container, false)


        binding.buttonMatchList.setOnClickListener {
            val fragment = MatchListFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment).commit()
        }


        return binding.root
    }


}