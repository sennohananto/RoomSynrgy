package com.binar.roomsynrgy.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.binar.roomsynrgy.db.Item
import com.binar.roomsynrgy.db.ItemDatabase
import com.binar.roomsynrgy.R
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity(), AddActivityPresenter.Listener {
    private lateinit var db: ItemDatabase
    lateinit var presenter: AddActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        ItemDatabase.getInstance(this)?.let {
            db = it
            presenter = AddActivityPresenter(db, this)
        }

        btnSave.setOnClickListener {
            val item = Item(
                null,
                etName.text.toString(),
                etQuantity.text.toString().toInt()
            )

            presenter.addItem(item)
        }
    }

    override fun showAddSuccessMessage(item: Item) {
        Log.d("ROOM","Data ${item.name} Disimpan")
        finish()
    }

    override fun showAddFailedMessage(item: Item) {
        Log.d("ROOM","Data ${item.name} Gagal Disimpan")
    }
}