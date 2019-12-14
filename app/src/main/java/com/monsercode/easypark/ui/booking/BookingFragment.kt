package com.monsercode.easypark.ui.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.monsercode.easypark.R
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.toast

class BookingFragment : Fragment() {
    private lateinit var bookingViewModel : BookingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookingViewModel = ViewModelProviders.of(this).get(BookingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_booking, container, false)
        longToast("Bookings")
        return root
    }
}