package fr.isen.deleuziere.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.deleuziere.androiderestaurant.model.Items


class CategoryAdapter(private var dishes: ArrayList<Items>, val onItemClickListener: (name: Items?) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellName = view.findViewById<TextView>(R.id.cellName) // Extract cellName
        val priceValue = view.findViewById<TextView>(R.id.priceValue) // Extract cellName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meal_cell, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val dish = dishes[position]

        holder.cellName.text = dish.nameFr

        var price:String? =""
        for (i in dish.prices) {
            price = price + i.price + "€ "
        }
        holder.priceValue.text = price

        holder.itemView.setOnClickListener {
            onItemClickListener(dish)
        }
    }

    override fun getItemCount(): Int = dishes.size

    fun refreshList(dishesFromAPI:ArrayList<Items>) {
        dishes = dishesFromAPI
        notifyDataSetChanged()
    }
}
