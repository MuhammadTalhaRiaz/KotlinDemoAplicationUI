package downlaod.video.kotlinaplication.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import downlaod.video.kotlinaplication.HomeFragment
import downlaod.video.kotlinaplication.R

class HorizontalRecyclerViewAdapter : RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder>() {

    private val kategori = arrayOf("Title", "Title",
        "Title", "Title",
        "Title", "Title",
        "Title", "Title")

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemKode: TextView
        var imageView: ImageView

        init {
            itemKode = itemView.findViewById(R.id.name)
            imageView = itemView.findViewById(R.id.image)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, HomeFragment::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemKode.text)

                }
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.horizontalrecyclerview, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemKode.text = kategori[i]
    }

    override fun getItemCount(): Int {
        return kategori.size
    }

}