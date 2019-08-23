package com.app.delivery.mvp.vp.delivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.delivery.R
import com.app.delivery.mvp.models.Delivery

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_delivery_detail.*


class DeliveryDetailActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var deliveryItem : Delivery

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_detail)


        deliveryItem = intent.getParcelableExtra("delivery")

        delivery_list_row.text = deliveryItem.description +" - "+deliveryItem.location.address

        supportActionBar?.title = getString(R.string.delivery_location)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(deliveryItem.location.lat, deliveryItem.location.lng)
        mMap.addMarker(MarkerOptions().position(sydney).title(deliveryItem.location.address))
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val zoomLevel = 13.0f //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel))
    }
}
