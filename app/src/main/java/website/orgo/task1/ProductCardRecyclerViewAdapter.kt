package website.orgo.task1

import android.content.Context
import website.orgo.task1.models.ItemResponse
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.Glide

/**
 * Adapter used to show a simple grid of products.
 */
class ProductCardRecyclerViewAdapter//        imageRequester = ImageRequester.getInstance();  //    private ImageRequester imageRequester;
internal constructor(private val productList: List<ItemResponse>?,private val  requireContext: Context) :
    RecyclerView.Adapter<ProductCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val layoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_item_layout, parent, false)
        return ProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
        if (productList != null && position < 2000) {
            val product = productList[position]
            holder.productTitle.setText(product.itemName)
            holder.productPrice.setText(product.itemPrice.toString())
//            imageRequester.setImageFromUrl(holder.productImage, product.url)
//            ImageView imageView = (ImageView) findViewById(R.id.imageView);
//
            Glide.with(requireContext)

                .load(product.url.toString())

//            .placeholder(R.drawable.placeholder)

                .into(holder.productImage)

//                .error(R.drawable.imagenotfound);
        }
    }

    override fun getItemCount(): Int {
        return productList!!.size
    }
}