package com.binar.roomsynrgy.edit

import android.widget.Toast
import com.binar.roomsynrgy.db.Item
import com.binar.roomsynrgy.db.ItemDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditActivityPresenter(val db: ItemDatabase, val listener: Listener){

    fun editItem(item: Item){

        GlobalScope.launch {
            val rowUpdated = db.itemDao().updateItem(item)

            if(rowUpdated>0){
                listener.showEditSuccess(item)
            }else{
                listener.showEditFailed(item)
            }

        }
    }

    interface Listener{
        fun showEditSuccess(item: Item)
        fun showEditFailed(item: Item)
    }
}