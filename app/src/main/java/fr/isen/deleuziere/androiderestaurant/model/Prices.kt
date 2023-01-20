package fr.isen.deleuziere.androiderestaurant.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class Prices (

  @SerializedName("id"          ) var id         : String? = null,
  @SerializedName("id_pizza"    ) var idPizza    : String? = null,
  @SerializedName("id_size"     ) var idSize     : String? = null,
  @SerializedName("price"       ) var price      : String? = null,
  @SerializedName("create_date" ) var createDate : String? = null,
  @SerializedName("update_date" ) var updateDate : String? = null,
  @SerializedName("size"        ) var size       : String? = null

):java.io.Serializable
