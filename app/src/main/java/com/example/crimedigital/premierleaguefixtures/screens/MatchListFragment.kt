package com.example.crimedigital.premierleaguefixtures.screens

import MatchAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crimedigital.premierleaguefixtures.data.api.MatchApi
import com.example.crimedigital.premierleaguefixtures.data.repository.MatchRepository
import com.example.crimedigital.premierleaguefixtures.data.viewmodel.MatchViewModel
import com.example.crimedigital.premierleaguefixtures.databinding.FragmentMatchListBinding
import com.example.crimedigital.premierleaguefixtures.model.MatchModel
import com.example.crimedigital.premierleaguefixtures.data.viewmodel.MatchViewModelFactory

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MatchListFragment : Fragment() {
    private lateinit var binding: FragmentMatchListBinding
    private lateinit var adapter: MatchAdapter
    private val viewModel: MatchViewModel by viewModels {
        val repository = MatchRepository(MatchApi.retrofitService)
        MatchViewModelFactory(repository)
    }

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
        binding.recyclerViewMatch.adapter = adapter

        lifecycleScope.launch {
            viewModel.matchFlow.collectLatest { pagingData: PagingData<MatchModel> ->
                adapter.submitData(pagingData)
            }
        }
    }

    private fun setupButtonClick() {
//        binding.buttonMatchDetails.setOnClickListener {
//            findNavController().navigate(R.id.action_matchListFragment_to_matchDetailsFragment)
//        }
    }
}


//MatchListFragment управляет отображением списка матчей.
//Инициализирует RecyclerView и связывает его с MatchAdapter.
//Использует MatchViewModel для загрузки данных и отображения их в RecyclerView.
//lifecycleScope.launch используется для запуска корутин, которые обрабатывают потоки данных.