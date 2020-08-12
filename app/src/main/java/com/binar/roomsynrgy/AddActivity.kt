package com.binar.roomsynrgy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var db: ItemDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        ItemDatabase.getInstance(this)?.let {
            db = it
        }

        btnSave.setOnClickListener {
            val item = Item(null, etName.text.toString(), etQuantity.text.toString().toInt())
            GlobalScope.launch {
                val totalSaved = db.itemDao().addItem(item)
                runOnUiThread {
                    if(totalSaved>0){
                        Toast.makeText(this@AddActivity,"Data Sukses Disimpan", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@AddActivity,"Data Gagal Disimpan", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}