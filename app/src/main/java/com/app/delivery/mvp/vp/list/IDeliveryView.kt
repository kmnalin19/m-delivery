package com.app.delivery.mvp.vp.list

import com.app.delivery.mvp.models.Delivery
import listeners.IView

interface IDeliveryView : IView {

    fun deliveryItemSelect(delivery: Delivery)
}