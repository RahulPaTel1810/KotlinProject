package com.example.kotlinsimpledemo.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsimpledemo.Model.MainCatList
import com.example.kotlinsimpledemo.R
import com.example.kotlinsimpledemo.SecondActivity
import de.hdodenhof.circleimageview.CircleImageView

class MainCatAdapter(val maincatlist: ArrayList<MainCatList>) :
    RecyclerView.Adapter<MainCatAdapter.ViewHolder>() {


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val profileimage = itemview.findViewById(R.id.profile_image) as CircleImageView
        val textviewName = itemview.findViewById(R.id.textviewname) as TextView
        val textviewAddress = itemview.findViewById(R.id.textviewaddress) as TextView
        val maincatlayout = itemview.findViewById(R.id.maincatlayout) as LinearLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.main_cat_list, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return maincatlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val maincatlist: MainCatList = maincatlist[position]

        holder.profileimage.setImageResource(maincatlist.profileimage)
        holder.textviewName.text = maincatlist.name
        holder.textviewAddress.text = maincatlist.desc
        holder.profileimage.imageAlpha = maincatlist.profileimage
        holder.maincatlayout.setOnClickListener {
            val intent = Intent(holder.itemView.context,SecondActivity::class.java)
            intent.putExtra("image",maincatlist.profileimage)
            intent.putExtra("name",maincatlist.name)
            intent.putExtra("desc",maincatlist.desc)
            holder.itemView.context.startActivity(intent)
        }

    }

}