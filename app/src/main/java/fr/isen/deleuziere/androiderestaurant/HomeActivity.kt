package fr.isen.deleuziere.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val action1 = findViewById<TextView>(R.id.PlatsButton)
        action1.setOnClickListener{
            Toast.makeText(this, "Chargement des entrées", Toast.LENGTH_SHORT).show()
            //Snackbar.make(it, "Hello ISEN M1", Snackbar.LENGTH_SHORT).show()
        }

        val action2 = findViewById<TextView>(R.id.EntreesButton)
        action2.setOnClickListener{
            Toast.makeText(this, "Chargement des plats", Toast.LENGTH_SHORT).show()
        }

        val action3 = findViewById<TextView>(R.id.DessertsButton)
        action3.setOnClickListener{
            Toast.makeText(this, "Chargement des desserts", Toast.LENGTH_SHORT).show()
        }
    }
}