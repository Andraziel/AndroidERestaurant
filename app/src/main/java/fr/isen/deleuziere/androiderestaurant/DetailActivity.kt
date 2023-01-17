package fr.isen.deleuziere.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityMealBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val plat = intent.getStringExtra("plat")
        binding.platDisplay.text = plat
        val actionBar = supportActionBar
        actionBar?.title = plat
    }
}