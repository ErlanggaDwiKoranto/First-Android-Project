package com.example.androidpemula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class MyAdapter(private val senjataList: ArrayList<ListSenjata>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var itemListener: onItemClickListener

    interface onItemClickListener{
        fun onItemOnClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        itemListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_item, parent, false)
        return MyViewHolder(itemView, itemListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind the data to each item of RecyclerView
        val currentItem = senjataList[position]
        holder.titleImage.setImageResource(currentItem.gambarSenjata)
        holder.textTitle.text = currentItem.judulSenjata
        holder.textDescription.text = currentItem.deskSenjata
    }

    override fun getItemCount(): Int {
        // Return the size of the news list
        return senjataList.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ShapeableImageView = itemView.findViewById(R.id.titleImg)
        val textTitle: TextView = itemView.findViewById(R.id.text_title)
        val textDescription: TextView = itemView.findViewById(R.id.text_description)

        init {
            itemView.setOnClickListener{
                listener.onItemOnClick(adapterPosition)
            }
        }
    }
}