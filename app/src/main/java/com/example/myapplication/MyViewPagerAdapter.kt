import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Customer
import com.example.myapplication.R

class MyViewPagerAdapter(private val customers: List<Customer>) :
    RecyclerView.Adapter<MyViewPagerAdapter.ViewPagerViewHolder>() {

    // ViewHolder que representa cada página del ViewPager2
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewCustomerName)
        val imageView: ImageView = itemView.findViewById(R.id.imageViewCustomer)
        val statusImage: ImageView = itemView.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        // Inflamos el layout para cada página del ViewPager2
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_customer_page, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        // Asignamos los valores a las vistas
        val customer = customers[position]
        holder.nameTextView.text = customer.name

        Glide.with(holder.itemView.context)
            .load(customer.imageUrl)
            .into(holder.imageView)

        Glide.with(holder.itemView.context)
            .load(customer.status)
            .into(holder.statusImage)
    }

    override fun getItemCount(): Int = customers.size
}
