package com.example.licoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.licoapp.R
import com.example.licoapp.databinding.ModalBottomSheetContentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ModalBottomSheetContentBinding

    private lateinit var navController: NavController

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = ModalBottomSheetContentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       navController = Navigation.findNavController(requireActivity(), R.id.fragment)

        binding.imageCancel.setOnClickListener {
            dismiss()
        }

        binding.inventoryContainer.setOnClickListener {
            navController.navigate(R.id.page_inventory_add)
            dismiss()
        }
        binding.shippingContainer.setOnClickListener {
            Toast.makeText(requireContext(), "add Shipping", Toast.LENGTH_SHORT).show()
        }
    }

}