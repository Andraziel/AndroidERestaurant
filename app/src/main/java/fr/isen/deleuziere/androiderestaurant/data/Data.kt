package fr.isen.deleuziere.androiderestaurant.data

class Data (val data:ArrayList<Categorie>) {
    operator fun get(i: Int): Categorie {
        return data[i]
    }

}