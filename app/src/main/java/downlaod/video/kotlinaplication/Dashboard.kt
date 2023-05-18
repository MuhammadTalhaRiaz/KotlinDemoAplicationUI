package downlaod.video.kotlinaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class Dashboard : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    var username = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Dashboard"
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        // Call findViewById on the NavigationView
        navView = findViewById(R.id.navView)
        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)
        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.drawerArrowDrawable.color = resources.getColor(R.color.white)
        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarToggle.syncState()


        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.firstItem -> {
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.secondtItem -> {
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.thirdItem -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
        getdata()
        bottomnavigation()
    }
    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navView)
        return true
    }

    // override the onBackPressed() function to close the Drawer when the back button is clicked
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    fun getdata(){
        username  = intent.getStringExtra("userName").toString()
    }
    fun bottomnavigation() {
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            val fragment: Fragment
            when (it.itemId) {
                R.id.home -> {

                    loadFragment(ChatFragment())
                    true
                }
                R.id.message -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.settings -> {
                    fragment = SettingFragment()
                    loadFragment(fragment)
                    true
                }
                else -> true
            }
        }

        bottomNav.setOnItemReselectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                Toast.makeText(this, "Home Item reselected", Toast.LENGTH_SHORT).show()
            }
            R.id.message -> {
                Toast.makeText(this, "Message Item reselected", Toast.LENGTH_SHORT).show()
            }
            R.id.settings -> {
                Toast.makeText(this, "Setting Item reselected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}




