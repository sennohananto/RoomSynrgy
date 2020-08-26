package com.binar.roomsynrgy.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.roomsynrgy.R
import com.binar.roomsynrgy.db.Item
import kotlinx.android.synthetic.main.stuff_item.view.*

class ItemAdapter(private val listItem: List<Item>, private val presenter: MainActivityPresenter): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stuff_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvName.text = listItem[position].name
        holder.itemView.tvQuantity.text = listItem[position].quantity.toString()

        holder.itemView.ivDelete.setOnClickListener {
            presenter.deleteItem(listItem[position])
        }

        holder.itemView.ivEdit.setOnClickListener {
            presenter.goToEditActivity(listItem[position])
        }
    }
}