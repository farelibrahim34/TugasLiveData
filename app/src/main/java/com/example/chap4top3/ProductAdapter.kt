package com.example.chap4top3

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chap4top3.databinding.ItemProductBinding

class ProductAdapter (var listProduct : ArrayList<Product>, private val mlistener : MainActivity): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){



    class ViewHolder (var binding : ItemProductBinding): RecyclerView.ViewHolder(binding.root){
//        var name = itemView.findViewById<TextView>(R.id.txtProduct)
//        var harga = itemView.findViewById<TextView>(R.id.txtHarga)
//        var img = itemView.findViewById<ImageView>(R.id.imgProduct)
        fun data(itemData : Product, listener : MainActivity){
            binding.dataprduct = itemData
            binding.detailklik = listener
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        var view =  LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
//        return ViewHolder(view)

        var view = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.name.text = listProduct[position].nama
//        holder.harga.text = listProduct[position].harga
//        holder.img.setImageResource(listProduct[position].image)
        holder.data(listProduct[position],mlistener)

    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    fun setDataProduct(itemData : ArrayList<Product>){
        this.listProduct = itemData
    }
    interface ItemClickListener{
        fun onItemClickListener(detail : Product)
    }
}