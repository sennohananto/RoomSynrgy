package com.binar.roomsynrgy.add

import android.widget.Toast
import com.binar.roomsynrgy.db.Item
import com.binar.roomsynrgy.db.ItemDatabase
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivityPresenter(val db: ItemDatabase, val listener: Listener){

    fun addItem(item: Item){

        GlobalScope.launch {
        val totalSaved = db.itemDao().addItem(item)
            if(totalSaved>0){
                listener.showAddSuccessMessage(item)
            }else{
                listener.showAddFailedMessage(item)
            }
        }
    }

    interface Listener{
        fun showAddSuccessMessage(item: Item)
        fun showAddFailedMessage(item: Item)
    }
}