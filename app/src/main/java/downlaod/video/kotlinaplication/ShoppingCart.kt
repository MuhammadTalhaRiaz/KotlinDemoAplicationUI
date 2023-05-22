package downlaod.video.kotlinaplication

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import downlaod.video.kotlinaplication.Adapter.CartListAdapter
import downlaod.video.kotlinaplication.Adapter.RecyclerAdapter


class ShoppingCart : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<CartListAdapter.ViewHolder>? = null
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Cart"
        setSupportActionBar(toolbar)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ShoppingCart)
            adapter = CartListAdapter()
        }
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}