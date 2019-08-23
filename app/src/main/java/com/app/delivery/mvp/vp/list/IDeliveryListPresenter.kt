package com.app.delivery.mvp.vp.list

import com.app.delivery.mvp.models.Delivery

/**
 *
 */
interface IDeliveryListPresenter {

    fun requestDeliveryListSucces(it : ArrayList<Delivery>)
    fun requestDeliveryListError()
}