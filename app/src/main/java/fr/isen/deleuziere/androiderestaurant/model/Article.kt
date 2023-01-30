package fr.isen.deleuziere.androiderestaurant.model

import com.google.gson.annotations.SerializedName

data class Article (
    @SerializedName("quantity"          ) var quantity         : String? = null,
    @SerializedName("price"          ) var price         : String? = null,
)
