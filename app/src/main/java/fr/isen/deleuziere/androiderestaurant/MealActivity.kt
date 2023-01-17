package fr.isen.deleuziere.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityMealBinding

class MealActivity : AppCompatActivity() {

    //define binding
    private lateinit var binding: ActivityMealBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set binding
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Extract category and set title and actionbar
        val category = intent.getStringExtra("category")
        binding.CategoryDisplay.text = category
        val actionBar = supportActionBar
        actionBar?.title = category

        // Check the category it's in
        when (category) {
            "Entrées" -> {
                binding.categoryDisplayText.text = "Voici nos superbes entrées !" //Change the displayed text

                val value = resources.getStringArray(R.array.entrees).toList() as ArrayList<String> // Get the "entrees" Array // Convert the Array to a list

                Log.d("Debug", value.toString()) // Log the generated list for verification

                binding.categoryList.layoutManager = LinearLayoutManager(this) // Set the layout manager for the RecyclerView

                binding.categoryList.adapter = CategoryAdapter(value) { // Set the adapter for the RecyclerView with the generated list
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("plat",it)
                    startActivity(intent)
                }
            }

            "Plats" -> {
                binding.categoryDisplayText.text = "Laissez vous tentez par un de nos magnifique plats !"

                val value = resources.getStringArray(R.array.plats).toList() as ArrayList<String>
                Log.d("Debug", value.toString())

                binding.categoryList.layoutManager = LinearLayoutManager(this)

                binding.categoryList.adapter = CategoryAdapter(value) {
                    val intent = Intent(this, DetailActivity::class.java)
                    startActivity(intent)
                }
            }

            "Desserts" -> {
                binding.categoryDisplayText.text = "Une petite douceur pour terminer..."

                val value = resources.getStringArray(R.array.desserts).toList() as ArrayList<String>
                Log.d("Debug", value.toString())

                binding.categoryList.layoutManager = LinearLayoutManager(this)

                binding.categoryList.adapter = CategoryAdapter(value) {
                    val intent = Intent(this, DetailActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}