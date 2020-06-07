package com.example.kotlinsimpledemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsimpledemo.Model.Data
import com.example.kotlinsimpledemo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(private val datalist: MutableList<Data>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(itemview: View) :RecyclerView.ViewHolder(itemview){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = datalist[position]

        val userfullname  = holder.itemView.user_full_name
        val userAvaterimage = holder.itemView.user_avatar

        val fullName = "${data.firstName} ${data.lastName}"
        userfullname.text = fullName

        Picasso.get().load(data.avatar).into(userAvaterimage)
        /*holder.itemView.setOnClickListener(
            Toast.makeText(this,fullName,Toast.LENGTH_SHORT).show()
        )*/
    }
}

