package website.orgo.task1

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import website.orgo.task1.R

class ProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var productImage: ImageView
    var productTitle: TextView
    var productPrice: TextView

    init {
        productImage = itemView.findViewById(R.id.product_image)
        productTitle = itemView.findViewById(R.id.product_title)
        productPrice = itemView.findViewById(R.id.product_price)
    }
}