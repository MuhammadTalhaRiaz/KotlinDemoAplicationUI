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

    private val kode = arrayOf("d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b")

    private val kategori = arrayOf("Status COde 2", "Status COde 2",
        "Status COde 2", "Status COde 2",
        "Status COde 2", "Status COde 2",
        "Status COde 2", "Status COde 2")

    private val isi = arrayOf("pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21")
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
        return kode.size
    }

}