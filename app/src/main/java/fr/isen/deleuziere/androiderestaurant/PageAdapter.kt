package fr.isen.deleuziere.androiderestaurant

import android.view.View
import androidx.viewpager.widget.PagerAdapter

class PageAdapter(private var images: ArrayList<String>, val OnImageListener: (name: String) -> Unit) : PagerAdapter() {
    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("Not yet implemented")
    }

}
