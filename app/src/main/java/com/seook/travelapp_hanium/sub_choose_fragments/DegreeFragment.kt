package com.seook.travelapp_hanium.sub_choose_fragments
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seook.travelapp_hanium.MainActivity
import com.seook.travelapp_hanium.R
import com.seook.travelapp_hanium.RecyclerAdapter
import com.seook.travelapp_hanium.RecyclerAdapter_Degree
import com.seook.travelapp_hanium.databinding.FragmentChooseBinding
import com.seook.travelapp_hanium.databinding.FragmentDegreeBinding
import kotlinx.android.synthetic.main.fragment_choose.*
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*

class DegreeFragment : Fragment() {

    private lateinit var binding: FragmentDegreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_degree, container, false)
        binding.backTap.setOnClickListener() {
            it.findNavController().navigate(R.id.action_degreeFragment_to_chooseFragment)

        }

        return binding.root
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter_Degree()
        }

    }
}