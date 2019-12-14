package com.monsercode.easypark.ui.park

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.monsercode.easypark.R
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.toast

class ParkFragment : Fragment() {
    private lateinit var parkViewModel : ParkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        parkViewModel = ViewModelProviders.of(this).get(ParkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_park, container, false)
        longToast("Nearby Parks")
        return root
    }
}