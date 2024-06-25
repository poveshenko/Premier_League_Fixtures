package com.example.crimedigital.premierleaguefixtures.lesson_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.crimedigital.premierleaguefixtures.R
import com.example.crimedigital.premierleaguefixtures.databinding.FragmentMatchListBinding


class MatchListFragment : Fragment() {
    private lateinit var binding: FragmentMatchListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMatchListBinding.inflate(inflater, container, false)
        binding.buttonMatchDetails.setOnClickListener {
            val fragment = MatchDetailsFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
                .commit()
        }



        return binding.root
    }


}