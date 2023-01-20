package fr.isen.deleuziere.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityMealBinding
import fr.isen.deleuziere.androiderestaurant.model.DataResult
import fr.isen.deleuziere.androiderestaurant.model.Items

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val valeur = intent.extras?.getParcelable("plat",Items?:)

        val plat = intent.getSerializableExtra("plat") as Items

        //var valeur = Gson().fromJson(plat, Items::class.java)

        val actionBar = supportActionBar
        actionBar?.title = plat?.nameFr
        binding.platDisplay.text = plat?.nameFr

        val image = plat.images[0]
        if (image != "") { Picasso.get().load(image).into(binding.image) }





    }
}