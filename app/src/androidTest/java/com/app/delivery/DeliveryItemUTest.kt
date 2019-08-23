package com.app.delivery

import async.AsyncDeliveryListInteractor
import com.app.delivery.mvp.models.Delivery
import com.app.delivery.mvp.vp.list.DeliveryListPresenter
import com.app.delivery.mvp.vp.list.IDeliveryListPresenter
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DeliveryItemUTest : IDeliveryListPresenter {

    private lateinit var deliveryListInteractor : AsyncDeliveryListInteractor


    @Before
    fun setUp() {
        deliveryListInteractor = AsyncDeliveryListInteractor(this)
    }

    @Test
    fun testDeliveryListData(){
        deliveryListInteractor.requestDeliveryList()
    }


    override fun requestDeliveryListError() {

    }

    override fun requestDeliveryListSucces(it: ArrayList<Delivery>) {
        Assert.assertNotNull(it)
    }
}