package com.app.delivery.mvp.vp.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import base.BaseFragment
import com.app.delivery.R
import com.app.delivery.mvp.models.Delivery
import com.app.delivery.mvp.vp.delivery.DeliveryDetailActivity

/**
 * show Delivery item List
 * extend BaseFragment
 */
class DeliveryListFragment : BaseFragment<DeliveryListPresenter>(),IDeliveryView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.deliverylist_fragment_window, container, false)
    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * create Presenter
     * after oncreate()
     * iDeliveryView to handle fragment events
     * @param view -  deliverylist_fragment_window
     * @return BasePresenter type
     */
    override fun instantiatePresenter(view: View): DeliveryListPresenter {
        return DeliveryListPresenter(this,view)
    }

    /**
     * @param delivery list item click listner will return delivery object from the list
     * load DeliveryDetailActivity
     */
    override fun deliveryItemSelect(delivery: Delivery) {

        val intent = Intent (activity, DeliveryDetailActivity::class.java)
        intent.putExtra("delivery",delivery)
        activity!!.startActivity(intent)

    }
}