package com.seook.travelapp_hanium.sub_choose_fragments

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seook.travelapp_hanium.R
import com.seook.travelapp_hanium.sub_choose_fragments.DegreeFragment
import kotlinx.android.synthetic.main.fragment_choose.*

class RecyclerAdapter_Degree : RecyclerView.Adapter<RecyclerAdapter_Degree.ViewHolder>() {

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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemKode: TextView
        var itemKategori: TextView
        var itemIsi: TextView

        init {
            itemKode = itemView.findViewById(R.id.kodePertanyaan)
            itemKategori = itemView.findViewById(R.id.kategori)
            itemIsi = itemView.findViewById(R.id.isiPertanyaan)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context

                val intent = Intent(context, DegreeFragment::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemKode.text)
                    putExtra("CATEGORY", itemKategori.text)
                    putExtra("CONTENT", itemIsi.text)
                }
                context.startActivity(intent)
            }
        }

    }
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


}