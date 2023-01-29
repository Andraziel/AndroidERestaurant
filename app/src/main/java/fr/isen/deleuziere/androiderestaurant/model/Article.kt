package fr.isen.deleuziere.androiderestaurant.model

import com.google.gson.annotations.SerializedName

data class Article (
    @SerializedName("quantity"          ) var quantity         : Int? = null,
    @SerializedName("price"          ) var price         : Int? = null,
)
