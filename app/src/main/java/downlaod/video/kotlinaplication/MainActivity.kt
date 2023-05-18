package downlaod.video.kotlinaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init(){
        var userName = findViewById(R.id.et_user_name)as EditText;
        var password = findViewById(R.id.et_password)as EditText;
        var submit = findViewById(R.id.btn_submit)as Button;
        var reset = findViewById(R.id.btn_reset)as Button;

        submit.setOnClickListener{
            val name = userName.text.toString()
            val pass = password.text
            val Intent  = Intent(this,Dashboard::class.java)
            Intent.putExtra("userName",name)
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
            startActivity(Intent)
        }
        reset.setOnClickListener{
            userName.setText("")
            password.setText("")
        }
    }
}