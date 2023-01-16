package fr.isen.deleuziere.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action = findViewById<Button>(R.id.homeMainAction)
        action.setOnClickListener{
            Toast.makeText(this, "Hello ISEN M1", Toast.LENGTH_SHORT).show()
            Snackbar.make(it, "Hello ISEN M1", Snackbar.LENGTH_SHORT).show()
        }
    }
}