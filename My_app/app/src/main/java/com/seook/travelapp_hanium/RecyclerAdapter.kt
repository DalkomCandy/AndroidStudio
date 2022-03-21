package com.seook.travelapp_hanium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.findNavController
import com.seook.travelapp_hanium.databinding.FragmentChooseBinding



class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var binding: FragmentChooseBinding

    private val kode = arrayOf(
        "학력",
        "인턴 경험",
        "대외활동",
        "동아리",
        "봉사활동",
        "아르바이트",
        "해외경험"
    )

    private val kategori = arrayOf(
        "Kekayaan", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana"
    )

    private val isi = arrayOf(
        "pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21"
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