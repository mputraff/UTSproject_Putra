package lat.pam.utsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnFoodClickListener {
    fun onFoodClick(food: Food)
}

class FoodAdapter(
    private val foodList: List<Food>,
    private val listener: OnFoodClickListener
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.apply {
            foodName.text = food.name
            foodDescription.text = food.description
            foodImage.setImageResource(food.imageResourceId)

            // Menambahkan click listener
            itemView.setOnClickListener {
                listener.onFoodClick(food)
            }
        }
    }

    override fun getItemCount(): Int = foodList.size

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodDescription: TextView = itemView.findViewById(R.id.foodDescription)
    }
}