package fr.isen.deleuziere.androiderestaurant.model

import com.google.gson.annotations.SerializedName

data class Panier (
        @SerializedName("articles"        ) var articles      : ArrayList<Article>      = arrayListOf(),
)