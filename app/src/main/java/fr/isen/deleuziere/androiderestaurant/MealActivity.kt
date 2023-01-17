package fr.isen.deleuziere.androiderestaurant

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

        //set binding
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // extract category and set title and actionbar
        val category = intent.getStringExtra("category")
        binding.CategoryDisplay.text = category
        val actionBar = supportActionBar
        actionBar?.title = category

        // Check the category it's in
        when (category) {
            "Entrées" -> {

                val value = resources.getStringArray(R.array.entrees) // Get the "entrees" Array

                val valuelist = ArrayList<String>(value.toList()) // Convert the Array to a list

                Log.d("Debug", valuelist.toString()) // Log the generated list for verification

                binding.categoryList.adapter = CategoryAdapter(valuelist) // Set the adapter for the RecyclerView with the generated list

                binding.categoryList.layoutManager = LinearLayoutManager(this) // Set the layout manager for the RecyclerView

            }
            "Plats" -> {
                val value = resources.getStringArray(R.array.plats)
                val valuelist = ArrayList<String>(value.toList())
                Log.d("Debug", valuelist.toString())

                binding.categoryList.adapter = CategoryAdapter(valuelist)
                binding.categoryList.layoutManager = LinearLayoutManager(this)

            }
            "Desserts" -> {
                val value = resources.getStringArray(R.array.desserts)
                val valuelist = ArrayList<String>(value.toList())
                Log.d("Debug", valuelist.toString())

                binding.categoryList.adapter = CategoryAdapter(valuelist)
                binding.categoryList.layoutManager = LinearLayoutManager(this)

            }
        }
    }
}