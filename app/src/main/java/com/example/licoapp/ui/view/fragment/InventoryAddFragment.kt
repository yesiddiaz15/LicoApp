package com.example.licoapp.ui.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.licoapp.R
import com.example.licoapp.databinding.InventoryAddFragmentBinding
import com.example.licoapp.ui.viewmodel.ERROR
import com.example.licoapp.ui.viewmodel.InventoryAddViewModel
import com.example.licoapp.ui.viewmodel.SUCCESS

class InventoryAddFragment : Fragment() {

    private lateinit var inventoryAddViewModel: InventoryAddViewModel
    private lateinit var binding: InventoryAddFragmentBinding

    private lateinit var navController: NavController


    companion object {
        fun newInstance() = InventoryAddFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        inventoryAddViewModel = ViewModelProvider(this)[InventoryAddViewModel::class.java]

        binding =
            DataBindingUtil.inflate(inflater, R.layout.inventory_add_fragment, container, false)
        binding.inventoryViewModel = inventoryAddViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        inventoryAddViewModel = ViewModelProvider(this)[InventoryAddViewModel::class.java]

        navController = Navigation.findNavController(requireActivity(), R.id.fragment)

        inventoryAddViewModel.success.observe(this, {
            when (it){
                SUCCESS.CLOSE_SUCCESS -> {
                    Log.e("TAG","CLOSE")
                    navController.navigate(R.id.page_inventory)
                }
                SUCCESS.ADD_SUCCESS ->{
                    Log.e("TAG","ADD")
                    Toast.makeText(requireContext(),"Add liquor :) successful",Toast.LENGTH_SHORT).show()
                }
            }

        })

        inventoryAddViewModel.error.observe(this,{
            when (it){
                ERROR.EMPTY_FIELDS -> {
                    Toast.makeText(requireContext(),"CAMPOS VACIOS",Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

}