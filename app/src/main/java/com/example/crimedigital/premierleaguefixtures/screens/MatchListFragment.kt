package com.example.crimedigital.premierleaguefixtures.screens

import MatchAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crimedigital.premierleaguefixtures.R
import com.example.crimedigital.premierleaguefixtures.data.MatchDataSource
import com.example.crimedigital.premierleaguefixtures.databinding.FragmentMatchListBinding
import com.example.crimedigital.premierleaguefixtures.model.MatchModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MatchListFragment : Fragment() {
    private lateinit var binding: FragmentMatchListBinding
    private lateinit var adapter: MatchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchListBinding.inflate(inflater, container, false)

        initializeRecyclerView()
        setupButtonClick()
        return binding.root
    }

    private fun initializeRecyclerView() {
        adapter = MatchAdapter()
        binding.recyclerViewMatch.layoutManager = LinearLayoutManager(context)

        val pager = Pager(PagingConfig(pageSize = 10)) {
            MatchDataSource(createFakeMatches())
        }

        lifecycleScope.launch {
            pager.flow.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        binding.recyclerViewMatch.adapter = adapter
    }

    private fun setupButtonClick() {
        binding.buttonMatchDetails.setOnClickListener {
            findNavController().navigate(R.id.action_matchListFragment_to_matchDetailsFragment)
        }
    }

    private fun createFakeMatches(): List<MatchModel> {
        return listOf(
            MatchModel("Arsenal", 1, "2023.08.11", 0, "Barselona", 1, "Barselona", 2, 1),
            MatchModel("Chelsea", 2, "2023.08.11", 2, "Spartak", 2, "Russia", 1, 2)
        )
    }
}
