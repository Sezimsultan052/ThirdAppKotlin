package com.example.thirdappkotlin.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdappkotlin.databinding.ItemImgBinding
import com.example.thirdappkotlin.ui.main.AdapterMAin.*

class AdapterMAin(private val listener : SelectListener) :
    RecyclerView.Adapter<AdapterMAin.MainViewHolder>() {
    private var imgList = arrayListOf<Int>()

    fun setImageList(imgList: ArrayList<Int>){
        this.imgList = imgList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding : ItemImgBinding =
            ItemImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(imgList[position])
        holder.binding.ivItem.alpha = 1f
        holder.itemView.setOnClickListener{
            holder.binding.ivItem.alpha = 0.5f
            listener.select(imgList[position])
            true
        }
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    class MainViewHolder(val binding: ItemImgBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(img: Int) {
            binding.ivItem.setImageResource(img)
        }
    }


    interface SelectListener {
        fun select(selectImg: Int)
    }
}