package fr.isen.deleuziere.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MealActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)

        val category = intent.getStringExtra("category")
        val CategoryDisplay = findViewById<TextView>(R.id.CategoryDisplay)
        CategoryDisplay.text = category
    }
}