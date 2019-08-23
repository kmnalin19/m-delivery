package com.app.delivery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.delivery.R
import com.app.delivery.mvp.models.Delivery
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.delivery_list_row.view.*
import listeners.RecycleViewClickListner

class DeliverListAdapter(val deliveryList: ArrayList<Delivery>,val recycleViewClickListner : RecycleViewClickListner) :  RecyclerView.Adapter<DeliverListAdapter.DeliverListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliverListViewHolder {
        val inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_list_row, parent, false);
        return DeliverListViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
       return deliveryList.size
    }

    override fun onBindViewHolder(holder: DeliverListViewHolder, position: Int) {

        deliveryList[position].imageUrl.let {
            Picasso.get().load(it).into(holder.view.delivery_row_item_image)
        }
        deliveryList[position].description.let {
            holder.view.delivery_row_item_description.text = it
        }
        deliveryList[position].location.address.let {
            holder.view.delivery_row_item_address.text = deliveryList[position].location.address
        }
        holder.view.setOnClickListener {
            recycleViewClickListner.setOnSelectListener(deliveryList.get(it.tag as Int))
        }
        holder.view.tag = position
    }


    class DeliverListViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view: View = v
    }


}