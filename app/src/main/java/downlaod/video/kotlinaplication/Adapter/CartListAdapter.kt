package downlaod.video.kotlinaplication.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import downlaod.video.kotlinaplication.R

class CartListAdapter : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    var count = 1
     var counttext =""


    private val Title = arrayOf("Title", "Title", "Title")

    private val Price = arrayOf("Price", "Price", "Price",)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     var title: TextView
     var price: TextView
        init {
            title = itemView.findViewById(R.id.order_title)
            price = itemView.findViewById(R.id.order_price)
//
            itemView.setOnClickListener {
                var position: Int = adapterPosition
                val context = itemView.context
//                val intent = Intent(context, HomeFragment::class.java).apply {
//                    putExtra("NUMBER", position)
//                    putExtra("CODE", itemCode.text)
//                    putExtra("CATEGORY", itemCategori.text)
//                    putExtra("CONTENT", itemIsi.text)
//                }
//                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cartlist, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.title.text = Title[i]
        viewHolder.price.text = Price[i]
    }

    override fun getItemCount(): Int {
        return Title.size
    }
}