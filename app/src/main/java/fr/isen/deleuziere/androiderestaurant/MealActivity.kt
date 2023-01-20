package fr.isen.deleuziere.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityMealBinding
import fr.isen.deleuziere.androiderestaurant.model.DataResult
import org.json.JSONObject

class MealActivity : AppCompatActivity() {

    //define binding
    private lateinit var binding: ActivityMealBinding
    private lateinit var category: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadDishesFromAPI() // Load Data from the API

        // Set binding
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Extract category and set title and actionbar
        category = intent.getStringExtra("category") ?: ""
        binding.CategoryDisplay.text = category

        val actionBar = supportActionBar
        actionBar?.title = category

        // Check the category it's in
        when (category) {

            "Entrées" -> {
                binding.categoryDisplayText.text = "Voici nos superbes entrées !" //Change the displayed text

                val value = resources.getStringArray(R.array.entrees).toList() as ArrayList<String> // Get the "entrees" Array // Convert the Array to a list

                //Log.d("Debug", value.toString()) // Log the generated list for verification

                binding.categoryList.layoutManager = LinearLayoutManager(this) // Set the layout manager for the RecyclerView

                binding.categoryList.adapter = CategoryAdapter(value) { // New one, check what has changed and adjust

                    val intent = Intent(this, DetailActivity::class.java)

                    intent.putExtra("plat","$it")
                    startActivity(intent)
                }

                /*binding.categoryList.adapter = CategoryAdapter(value) { // Set the adapter for the RecyclerView with the generated list
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("plat","$it")
                    startActivity(intent)
                }*/
            }

            "Plats" -> {/*
                binding.categoryDisplayText.text = "Laissez vous tentez par un de nos magnifique plats !"

                val value = resources.getStringArray(R.array.plats).toList() as ArrayList<String>
                Log.d("Debug", value.toString())

                binding.categoryList.layoutManager = LinearLayoutManager(this)

                binding.categoryList.adapter = CategoryAdapter(value) {
                    val intent = Intent(this, DetailActivity::class.java)
                    startActivity(intent)
                }*/
            }

            "Desserts" -> {/*
                binding.categoryDisplayText.text = "Une petite douceur pour terminer..."

                val value = resources.getStringArray(R.array.desserts).toList() as ArrayList<String>
                Log.d("Debug", value.toString())

                binding.categoryList.layoutManager = LinearLayoutManager(this)

                binding.categoryList.adapter = CategoryAdapter(value) {
                    val intent = Intent(this, DetailActivity::class.java)
                    startActivity(intent)
                }*/
            }
        }
    }
    private fun loadDishesFromAPI() {

        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, {
                Log.w("CategoryActivity", "reponse : $it")
                handleAPIData(it.toString())
            }, {
                Log.w("CategoryActivity", "erreur : $it")
            }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data: String) {
        var dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategoryFiltered = dishesResult.data.firstOrNull { it.nameFr == category }

        val adapter = binding.categoryList.adapter as CategoryAdapter

        adapter.refreshList(dishCategoryFiltered?.items?.map { it.nameFr } as ArrayList<String>)
    }
}