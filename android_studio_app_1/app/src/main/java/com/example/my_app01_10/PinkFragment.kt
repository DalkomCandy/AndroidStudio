package com.example.my_app01_10

import android.os.Bundle

import android.view.ViewGroup

import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment


class PinkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pink, container, false)
    }
}