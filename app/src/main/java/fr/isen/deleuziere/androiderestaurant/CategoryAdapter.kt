package fr.isen.deleuziere.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CategoryAdapter(private var dishes: ArrayList<String>, val onItemClickListener: (name: String) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellName = view.findViewById<TextView>(R.id.cellName) // Extract cellName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meal_cell, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val dish = dishes[position]
        holder.cellName.text = dish
        holder.itemView.setOnClickListener {
            onItemClickListener(dish)
        }
    }

    override fun getItemCount(): Int = dishes.size

    fun refreshList(dishesFromAPI:ArrayList<String>) {
        dishes = dishesFromAPI
        notifyDataSetChanged()
    }
}
