package com.app.delivery.mvp.vp.list

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import async.AsyncDeliveryListInteractor
import base.BasePresenter
import com.app.delivery.adapters.DeliverListAdapter
import com.app.delivery.mvp.models.Delivery
import kotlinx.android.synthetic.main.deliverylist_fragment_window.view.*
import listeners.IView
import listeners.RecycleViewClickListner

/**
 * use for DeliveryListFragment and BasePresenter child
 * @param iDeliveryView
 * @param v - DeliveryListFragment layout
 */
class DeliveryListPresenter(val iDeliveryView : IDeliveryView,val v : View) : BasePresenter<IView>(iDeliveryView),IDeliveryListPresenter,RecycleViewClickListner{


    val deliveryListInteractor = AsyncDeliveryListInteractor(this)

    init {
        v.delivery_list_loading_spinner.visibility = View.VISIBLE
        deliveryListInteractor.requestDeliveryList()
    }

    /**
     *  hit after delivery list Successfully received
     *  @param ArrayList<Delivery>
     */
    override fun requestDeliveryListSucces(it : ArrayList<Delivery>) {
        v.delivery_list_loading_spinner.visibility = View.GONE
        v.delivery_list_recyclerView!!.layoutManager = LinearLayoutManager(iDeliveryView.requestActivity()) as RecyclerView.LayoutManager?
        v.delivery_list_recyclerView!!.adapter = DeliverListAdapter(it,this)
    }

    /**
     * handle delivery list request error
     */
    override fun requestDeliveryListError() {
    }

    /**
     * handle delivery list item click
     */
    override fun setOnSelectListener(value: Any) {
        iDeliveryView.deliveryItemSelect(value as Delivery)
    }

    override fun setOnDeSelectListener(value: Any) {
        v.delivery_list_loading_spinner.visibility = View.GONE
    }
}