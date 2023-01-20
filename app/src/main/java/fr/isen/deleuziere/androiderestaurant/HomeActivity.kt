package fr.isen.deleuziere.androiderestaurant

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MealActivity::class.java )

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EntreesButton.setOnClickListener{
            intent.putExtra("category",getString(R.string.starters))

            startActivity(intent)
        }

        binding.PlatsButton.setOnClickListener{
            //Toast.makeText(this, "Chargement des plats", Toast.LENGTH_SHORT).show()

            intent.putExtra("category","Plats")
            startActivity(intent)

            //Snackbar.make(it, "Hello ISEN M1", Snackbar.LENGTH_SHORT).show()
        }

        binding.DessertsButton.setOnClickListener{
            intent.putExtra("category","Desserts")
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Debug","Home destroyed")
    }
}