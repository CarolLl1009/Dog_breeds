package com.example.dogbreeds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreeds.databinding.ListBreedsBinding
import com.example.dogbreeds.model.local.DogsEntity

class BreedsAdapter : RecyclerView.Adapter<BreedsAdapter.BreedsVH>(){

    private var listBreeds = listOf<DogsEntity>()

    fun update(list : List<DogsEntity>) {
        listBreeds = list
        notifyDataSetChanged()
    }
//*****************************************************************
    inner class BreedsVH(private val mBinding: ListBreedsBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(breed : DogsEntity){
        mBinding.tvBreed.text = breed.breed

        }
    }
    //******************************************************************** aquí debe estar el problema

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsVH {
        return BreedsVH(ListBreedsBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun onBindViewHolder(holder: BreedsVH, position: Int) {
        val breed = listBreeds[position]
        holder.bind(breed)
    }

    override fun getItemCount(): Int = listBreeds.size


}