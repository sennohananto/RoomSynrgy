package com.binar.roomsynrgy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {
    private lateinit var db: ItemDatabase
    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        ItemDatabase.getInstance(this)?.let {
            db = it
        }

        intent.getParcelableExtra<Item>("item")?.let {
            item = it
        }

        etName.setText(item.name)
        etQuantity.setText(item.quantity.toString())

        btnSave.setOnClickListener {
            item.apply {
                name = etName.text.toString()
                quantity = etQuantity.text.toString().toInt()
            }

            GlobalScope.launch {
                val rowUpdated = db.itemDao().updateItem(item)

                runOnUiThread {
                    if(rowUpdated>0){
                        Toast.makeText(this@EditActivity,"Data Sukses Diupdate", Toast.LENGTH_LONG).show()
                        this@EditActivity.finish()
                    }else{
                        Toast.makeText(this@EditActivity,"Data Gagal Diupdate", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}