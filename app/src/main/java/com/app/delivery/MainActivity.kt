package com.app.delivery

import android.os.Bundle
import base.BaseActivity
import com.app.delivery.mvp.vp.list.DeliveryListFragment

/**
 *
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(DeliveryListFragment(), R.id.content_control)
    }
}
