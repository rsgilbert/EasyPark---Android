package com.monsercode.easypark.ui.park

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.monsercode.easypark.Park
import com.monsercode.easypark.ParkActivity
import com.monsercode.easypark.R
import com.monsercode.easypark.Utils
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.find

class ParkViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_park, parent, false)
), View.OnClickListener {
    private val park_profile_image = itemView.find<CircleImageView>(R.id.park_profile_image)
    private val park_name = itemView.find<TextView>(R.id.park_name)
    private val park_distance = itemView.find<TextView>(R.id.park_distance)

    var park: Park? = null
    var context: Context = parent.context

    init {
        itemView.setOnClickListener(this)
        Utils.setClickableAnimation(context, itemView)
    }

    fun bindTo(park: Park?) {
        this.park = park
        if (park != null) {
            with(park) {
                park_name.text = name
                park_distance.text = distance
                Glide.with(context)
                    .load(picture)
                    .placeholder(R.drawable.ic_park)
                    .into(park_profile_image)
            }
        }
    }

    override fun onClick(v: View?) {
        val intent = Intent(context, ParkActivity::class.java)
        intent.putExtra("Park", park)
        context.startActivity(intent)
    }
}

class ParkAdapter (private val parks: List<Park>) :
        RecyclerView.Adapter<ParkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ParkViewHolder(parent)

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        holder.bindTo(parks[position])
    }

    override fun getItemCount() = parks.size
}