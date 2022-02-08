package com.example.licoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.licoapp.databinding.ModalBottomSheetContentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ModalBottomSheetContentBinding

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = ModalBottomSheetContentBinding.inflate(inflater, container, false)

        binding.imageCancel.setOnClickListener {
            dismiss()
        }

        binding.inventoryContainer.setOnClickListener {
            Toast.makeText(requireContext(), "add Inventory", Toast.LENGTH_SHORT).show()
        }
        binding.shippingContainer.setOnClickListener {
            Toast.makeText(requireContext(), "add Shipping", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}