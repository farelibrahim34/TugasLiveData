package com.example.chap4top3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
//    deklarasi data
    val list = arrayListOf(
        Product("Malboro Black Filter",R.drawable.malboroblackf,"28.000","Rokok"),
        Product("Surya 16",R.drawable.surya16,"26.000","Rokok"),
        Product("Surya 12",R.drawable.surya12,"20.000","Rokok"),
        Product("Signature",R.drawable.signature,"19.500","Rokok"),
        Product("Sampurna",R.drawable.sampurna,"27.000","Rokok"),
        Product("Sampurna Splash Merah",R.drawable.splashmerah,"25.800","Rokok"),
        Product("Camel Purple",R.drawable.camelungu,"16.000","Rokok"),
        Product("Juara Kretek",R.drawable.juarakretek,"11.000","Rokok"),
        Product("Djarum Super",R.drawable.djarum,"19.000","Rokok"),
        Product("Berry Pop",R.drawable.berrypop,"28.000","Rokok"),
        Product("Honey Pop",R.drawable.honeypop,"28.000","Rokok"),

    )
//bikin live data
    val product : MutableLiveData<List<Product>> = MutableLiveData()
// set data ke livedata
    fun getProduct(){
        product.value = list
    }
}