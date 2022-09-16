package com.example.chap4top3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chap4top3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductAdapter.ItemClickListener {

    lateinit var binding :ActivityMainBinding

    lateinit var vmProduct : ViewModelProduct
    lateinit var adapterProduct : ProductAdapter
    lateinit var rvproduct  : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

//        init viewmodel

        vmProduct = ViewModelProvider(this).get(ViewModelProduct::class.java)
        adapterProduct = ProductAdapter(ArrayList(),this)


//        observ livedata
        vmProduct.getProduct()
        vmProduct.product.observe(this, Observer { adapterProduct.setDataProduct(it as ArrayList<Product>) })

//        rvproduct = findViewById(R.id.rvProduct)
//        rvproduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        rvproduct.adapter = adapterProduct

//        pake binding
        binding.rvProduct.adapter = adapterProduct
        binding.rvProduct.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


    }

    override fun onItemClickListener(detail: Product) {
        var pindah = Intent(this,DetailProduct::class.java)
        pindah.putExtra("detail",detail)
        startActivity(pindah)
    }
}