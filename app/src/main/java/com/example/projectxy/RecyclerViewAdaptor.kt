package com.example.projectxy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdaptor : RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder>() {
    private val itemTitels = arrayOf(
        "Parents are always worried about the health of their unborn child and his development.",
        "It is important for them to understand what diseases their future children can inherit",
        "Following diseases: Daltonism, Sickle call anemia, Phenylketonuria, Hypertrichosis, Hemophilia",
        "As for Android as for IOS"
    )
    private val itemImages = intArrayOf(
        R.drawable.rec_pregnant,
        R.drawable.newborn_rec,
        R.drawable.ilnesses,
        R.drawable.android_and_ios
    )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var text: TextView

        init {
            image = itemView.findViewById(R.id.item_image)
            text = itemView.findViewById(R.id.item_title)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v: View? = null
        v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_model, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = itemTitels[position]
        holder.image.setImageResource(itemImages[position])
        holder.itemView.setOnClickListener { v: View ->
            Toast.makeText(v.context, "THANK YOU FOR FOLLOWING US", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return itemTitels.size
    }
}