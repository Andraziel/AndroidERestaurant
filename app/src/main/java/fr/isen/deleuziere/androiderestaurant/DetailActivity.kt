package fr.isen.deleuziere.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.deleuziere.androiderestaurant.databinding.ActivityMealBinding
import fr.isen.deleuziere.androiderestaurant.model.Article
import fr.isen.deleuziere.androiderestaurant.model.DataResult
import fr.isen.deleuziere.androiderestaurant.model.Items
import fr.isen.deleuziere.androiderestaurant.model.Panier
import okhttp3.internal.platform.Platform
import java.io.File

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private var quantity: Int = 0
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val plat = intent.getSerializableExtra("plat") as Items


        val actionBar = supportActionBar
        actionBar?.title = plat?.nameFr
        binding.platDisplay.text = plat?.nameFr

        val image = plat.images[0]
        if (image != "") { if (image != null) {Picasso.get().load(image).into(binding.image) }}

        var ingredients:String? =""
        for (i in plat.ingredients) {
            ingredients = ingredients + i.nameFr + ", "
        }
        binding.ingredientView.text = ingredients

        binding.quantityView.text = quantity.toString()
        binding.buttonPrice.text = "Total " + plat.prices[0].price?.toFloat()?.times(quantity) + " €"

        binding.plusButton.setOnClickListener{
            updatePlus(plat)
        }
        binding.minusButton.setOnClickListener{
            updateMoins(plat)
        }
        binding.buttonPrice.setOnClickListener{
            updatePanier(plat)
        }


/*
        val viewPager = binding.viewPager
        viewPager.adapter = PageAdapter(arrayListOf<String>()) {

        }
*/
    }

    private fun updatePlus(plat:Items) {
        quantity += 1
        binding.quantityView.text = quantity.toString()
        binding.buttonPrice.text = "Total " + plat.prices[0].price?.toFloat()?.times(quantity) + " €"
    }

    private fun updateMoins(plat:Items) {
        quantity -= 1
        if (quantity < 0) {
            quantity = 0
        }
        binding.quantityView.text = quantity.toString()
        binding.buttonPrice.text = "Total " + plat.prices[0].price?.toFloat()?.times(quantity) + " €"
    }

    private fun updatePanier(plat:Items) {
        if (quantity != 0) {

            var fichier = File("./src/main/res/raw/data.json")
            val data: Article? = null
            data?.quantity = quantity
            data?.price = plat.prices[0].price?.toInt()
            val article = Gson().toJson(data, Article::class.java) as Article

            var articles = Gson().toJson(fichier.readText(), Panier::class.java) as ArrayList<Article>

            articles.add(article)

            fichier.writeText(articles.toString())

            Toast.makeText(this, "Ajout de $quantity ${plat.nameFr} au panier", Toast.LENGTH_SHORT).show()
            quantity = 0
            binding.quantityView.text = quantity.toString()
            binding.buttonPrice.text = "Total " + plat.prices[0].price?.toFloat()?.times(quantity) + " €"
        }
        else {
            Toast.makeText(this, "Vous devez entrer une quantité", Toast.LENGTH_SHORT).show()
        }
    }

}