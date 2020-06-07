package com.example.kotlinsimpledemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsimpledemo.R

class SecondAdapter(private var context: Context,
                    private var personNames: ArrayList<String>,
                    private var emailIds: ArrayList<String>,
                    private var mobileNumbers: ArrayList<String>) :
    RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        internal var name: TextView = itemView.findViewById(R.id.name) as TextView
        internal var email: TextView = itemView.findViewById(R.id.email) as TextView
        internal var mobileNo: TextView = itemView.findViewById(R.id.mobileNo) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.second_list_item, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return personNames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = personNames[position]
        holder.email.text = emailIds[position]
        holder.mobileNo.text = mobileNumbers[position]
    }

}
