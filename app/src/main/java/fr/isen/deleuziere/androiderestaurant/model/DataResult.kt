package fr.isen.deleuziere.androiderestaurant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class DataResult (

  @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

):java.io.Serializable
