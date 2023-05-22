package downlaod.video.kotlinaplication.Adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import downlaod.video.kotlinaplication.HomeFragment
import downlaod.video.kotlinaplication.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val Code = arrayOf("d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b")

    private val Category = arrayOf("Yamaha", "Honda",
        "Kawasaki", "Suzuki",
        "Yamaha", "Honda",
        "Kawasaki", "Suzuki",)

    private val isi = arrayOf("BIKE 22",
        "BIKE 11", "BIKE 17", "BIKE 33",
        "BIKE 12", "BIKE 18", "BIKE 20",
        "BIKE 21")
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemCode: TextView
        var itemCategori: TextView
        var itemIsi: TextView
        var serialNo: TextView

        init {
            itemCode = itemView.findViewById(R.id.kodePertanyaan)
            itemCategori = itemView.findViewById(R.id.kategori)
            itemIsi = itemView.findViewById(R.id.isiPertanyaan)
            serialNo = itemView.findViewById(R.id.txt_serial)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, HomeFragment::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemCode.text)
                    putExtra("CATEGORY", itemCategori.text)
                    putExtra("CONTENT", itemIsi.text)
                }
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerviewadapter, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemCode.text = Code[i]
        viewHolder.itemCategori.text = Category[i]
        viewHolder.itemIsi.text = isi[i]
        viewHolder.serialNo.text = (i + 1).toString()

    }

    override fun getItemCount(): Int {
        return Code.size
    }

}