package com.seook.travelapp_hanium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.seook.travelapp_hanium.databinding.FragmentDegreeBinding

class RecyclerAdapter_Degree : RecyclerView.Adapter<RecyclerAdapter_Degree.ViewHolder>() {

    private lateinit var binding: FragmentDegreeBinding

    private val kode = arrayOf(
        "인턴 1",
        "인턴 2",
        "인턴 1"
    )

    private val kategori = arrayOf(
        "기간",
        "기간",
        "기간"

    )

    private val isi = arrayOf(
        "느낀 점",
        "느낀 점",
        "느낀 점"
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemKode.text = kode[i]
        viewHolder.itemKategori.text = kategori[i]
        viewHolder.itemIsi.text = isi[i]
    }

    override fun getItemCount(): Int {
        return kode.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemKode: TextView = itemView.findViewById(R.id.kodePertanyaan)
        var itemKategori: TextView = itemView.findViewById(R.id.kategori)
        var itemIsi: TextView = itemView.findViewById(R.id.isiPertanyaan)

        init {
            itemView.setOnClickListener {
                if ( itemKode.text == "학력") {
                    it.findNavController().navigate(R.id.action_chooseFragment_to_degreeFragment)
                }
                else {
                    it.findNavController().navigate(R.id.action_chooseFragment_to_profileFragment)
                }
            }
        }
    }



}