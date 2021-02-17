package com.example.wisataapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wisataapp.R
import com.example.wisataapp.detail.DetailWisataActivity
import com.example.wisataapp.model.Wisata
import kotlinx.android.synthetic.main.item_wisata.view.*

class WisataAdapter(var data: ArrayList<Wisata>?) : RecyclerView.Adapter<WisataAdapter.WisataHolder>() {
    class WisataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img = itemView.itemImg
        val textName = itemView.itemNamaLokasi
        val itemNamaTempat = itemView.itemNamaTempat
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata,parent, false)

        val holder = WisataHolder(view)

        return holder
    }

    override fun getItemCount(): Int {
        return data?.size ?:0
    }

    override fun onBindViewHolder(holder: WisataHolder, position: Int) {
        holder.itemNamaTempat.text = data?.get(position)?.nama_tempat
        holder.textName.text = data?.get(position)?.lokasi

        Glide.with(holder.itemView.context).load(data?.get(position)?.gambar).into(holder.img)

        holder.itemView.setOnClickListener {

            //action klik
            val intent = Intent(holder.itemView.context, DetailWisataActivity::class.java)

            intent.putExtra("jdl", data?.get(position)?.nama_tempat)
            intent.putExtra("img", data?.get(position)?.gambar)
            intent.putExtra("desk", data?.get(position)?.deskripsi)

            holder.itemView.context.startActivity(intent)
        }
    }
}