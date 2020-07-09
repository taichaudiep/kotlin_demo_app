package com.example.demoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val mItems: ArrayList<Items>) :
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val title_tv = itemView.findViewById<TextView>(R.id.contact_title)
        val price_tv = itemView.findViewById<TextView>(R.id.contact_price)
        val sms_btn = itemView.findViewById<Button>(R.id.message_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Items = mItems.get(position)
        val title_tv = holder.title_tv
        val price_tv = holder.price_tv
        val sms_btn = holder.sms_btn
        title_tv.setText(item.title)
        price_tv.setText(item.price)
        sms_btn.text = if (item.isOnline) "Enable" else "Disable"
        sms_btn.isEnabled = item.isOnline
    }
}