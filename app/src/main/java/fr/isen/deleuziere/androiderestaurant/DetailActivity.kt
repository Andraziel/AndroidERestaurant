package fr.isen.deleuziere.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityMealBinding
import fr.isen.deleuziere.androiderestaurant.model.DataResult
import fr.isen.deleuziere.androiderestaurant.model.Items

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val valeur = intent.getStringExtra("plat")

        //var plat = Gson().fromJson(valeur, Items::class.java)

        binding.platDisplay.text = valeur//plat.nameFr
        val actionBar = supportActionBar
        actionBar?.title = valeur//plat.nameFr

    }
}