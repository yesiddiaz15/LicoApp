package com.example.licoapp.ui.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.licoapp.R
import com.example.licoapp.databinding.MainFragmentBinding
import com.example.licoapp.ui.viewModel.MainFragmentViewModel

class MainFragment : Fragment() {
    /**
     * This fragment is responsible about show  different recyclerView
     * according to the need
     */
    private lateinit var mainFragmentViewModel: MainFragmentViewModel
    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {



        mainFragmentViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.viewModelMainFragment = mainFragmentViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainFragmentViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        // TODO: Use the ViewModel
    }


}