package com.example.recyclerview


import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.adapter.AdapterTeamBola
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Pemain


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Albedo",R.drawable.albedo, "Mondstandt", "1.6m", "Unknown?", "20 May"))
        listPemain.add(Pemain("Xiao",R.drawable.xiao, "Liyue Adepti", "1.6m", "Unknown?", "20 May"))
        listPemain.add(Pemain("Kaedahara Kazuha",R.drawable.kazuha, "Inazuma", "1.7m", "Inazuma", "20 May"))
        listPemain.add(Pemain("Kujou Sara",R.drawable.sara, "Inazuma", "1.8m", "Inazuma", "20 May"))
        listPemain.add(Pemain("Sangonomiya Kokomi",R.drawable.kokomi, "Inazuma", "1.6m", "Watatsumi Island", "20 May"))
        listPemain.add(Pemain("Yelan",R.drawable.yelan_face, "Liyue", "1.9m", "Liyue", "20 May"))

        binding.list.adapter = AdapterTeamBola(this, listPemain, object : AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txt_namapemain)
                    val posisi = this.findViewById<TextView>(R.id.txt_posisi)
                    val tinggi = this.findViewById<TextView>(R.id.txt_tinggibadan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatLahir}"
                    tgllahir.text = "${item?.tglLahir}"

                    btn.setOnClickListener{
                        this.dismiss()
                    }
                }.show()
            }

        })

    }
}