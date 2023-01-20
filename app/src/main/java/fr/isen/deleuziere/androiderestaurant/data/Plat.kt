package fr.isen.deleuziere.androiderestaurant.data

class Plat (
    val id:String,
    val name_fr:String,
    val id_category:String,
    val categ_name_fr:String,
    val images:ArrayList<String>,
    val ingredients:ArrayList<Ingredient>,
    val prices:ArrayList<Price>
        ) {
}