package com.example.crimedigital.premierleaguefixtures.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.crimedigital.premierleaguefixtures.R
import com.example.crimedigital.premierleaguefixtures.databinding.FragmentMatchDetailsBinding

class MatchDetailsFragment : Fragment() {

    private var _binding: FragmentMatchDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchDetailsBinding.inflate(inflater, container, false)

        binding.apply {
            toolbar2.setNavigationOnClickListener {
                findNavController().navigate(R.id.action_matchDetailsFragment_to_matchListFragment)
            }

            buttonBack.setOnClickListener {
                findNavController().navigate(R.id.action_matchDetailsFragment_to_matchListFragment)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
