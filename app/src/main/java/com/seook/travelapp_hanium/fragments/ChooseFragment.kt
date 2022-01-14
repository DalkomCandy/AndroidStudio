package com.seook.travelapp_hanium.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seook.travelapp_hanium.R
import com.seook.travelapp_hanium.RecyclerAdapter
import com.seook.travelapp_hanium.databinding.FragmentChooseBinding
import kotlinx.android.synthetic.main.fragment_choose.*

class ChooseFragment : Fragment() {
    private lateinit var binding: FragmentChooseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose, container, false)

        binding.historyTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chooseFragment_to_historyFragment)
        }
        binding.profileTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chooseFragment_to_profileFragment)
        }
        binding.searchTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chooseFragment_to_searchFragment)
        }
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chooseFragment_to_homeFragment)
        }
        return binding.root
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter()
        }

    }


}