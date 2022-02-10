package com.example.licoapp.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.licoapp.R
import com.example.licoapp.ui.viewmodel.InventoryAddViewModel

class InventoryAddFragment : Fragment() {

    companion object {
        fun newInstance() = InventoryAddFragment()
    }

    private lateinit var viewModel: InventoryAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.inventory_add_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InventoryAddViewModel::class.java)
        // TODO: Use the ViewModel
    }

}