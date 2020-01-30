package com.monsercode.easypark.ui.park


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.monsercode.easypark.Park

class ParkViewModel(application: Application): AndroidViewModel(application) {
    val context = application.applicationContext

    private val allParks = listOf(
        Park("CIT Reserved Park", "10km"),
        Park("Mini Price Park", "5km"),
        Park("Kyengera Park", "8km"),
        Park("Shoprite Park", "3km")
    )
    val parks = MutableLiveData<List<Park>>().apply {
        value = allParks
    }



}