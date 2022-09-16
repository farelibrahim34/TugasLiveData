package com.example.chap4top3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_product.*

class DetailProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val getData = intent.getSerializableExtra("detail") as Product
        imgDetail.setImageResource(getData.image)
        txtDetailProduct.text = getData.nama
        txtDetailDesc.text = getData.deskripsi
        txtDetailHarga.text = getData.harga

        btnBuy.setOnClickListener {
//            val whatsapp = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/+62895358986590"))
//            whatsapp.putExtra(Intent.EXTRA_TEXT, "halo, saya tertarik dengan produk "+txtDetailProduct+" dengan harga \$100, apakah masih available?")
//
//            startActivity(Intent.createChooser(whatsapp,""))
//            startActivity(whatsapp)

            var intent = Intent()
            intent.setAction(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Halo, saya tertarik dengan produk "+getData.nama+" dengan harga Rp"+getData.harga+", apakah masih available?")
            intent.setType("text/plain")
            intent.setPackage("com.whatsapp")
            startActivity(Intent.createChooser(intent,""))
            startActivity(intent)





        }


    }
}