package com.binar.roomsynrgy.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.roomsynrgy.R
import com.binar.roomsynrgy.add.AddActivity
import com.binar.roomsynrgy.db.Item
import com.binar.roomsynrgy.db.ItemDatabase
import com.binar.roomsynrgy.edit.EditActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenter.Listener {
    private lateinit var presenter: MainActivityPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ItemDatabase.getInstance(this)?.let { presenter = MainActivityPresenter(it, this) }
        fabAdd.setOnClickListener { presenter.goToAddActivity() }
    }

    override fun onResume() {
        super.onResume()
        presenter.fetchData()
    }

    override fun showItemList(listItem: List<Item>){
        runOnUiThread {
            val adapter = ItemAdapter(listItem, presenter)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
        }
    }

    override fun goToAddActivity() {
        val intentGoToActivityAdd = Intent(this, AddActivity::class.java)
        startActivity(intentGoToActivityAdd)
    }

    override fun goToEditActivity(item: Item) {
        val intentGoToEditActivity = Intent(this, EditActivity::class.java)
        intentGoToEditActivity.putExtra("item", item)
        startActivity(intentGoToEditActivity)
    }

    override fun showDeletedSuccess(item: Item) {
        Toast.makeText(this, "Data ${item.name} Sukses Dihapus", Toast.LENGTH_LONG).show()
    }

    override fun showDeletedFailed(item: Item) {
        Toast.makeText(this, "Data ${item.name} Gagal Dihapus", Toast.LENGTH_LONG).show()
    }
}