package com.monsercode.easypark.ui.park

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monsercode.easypark.R
import com.monsercode.easypark.Utils
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.toast

class ParkFragment : Fragment() {
    private lateinit var parkViewModel : ParkViewModel
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        parkViewModel = ViewModelProviders.of(this).get(ParkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_park, container, false)
        val parkRecyclerView = root.find<RecyclerView>(R.id.park_recycler_view)
        parkRecyclerView.layoutManager = LinearLayoutManager(activity)
        Utils.putDivider(activity!!, parkRecyclerView)
        setHasOptionsMenu(true)

        parkViewModel.parks.observe(this, Observer {
            parkRecyclerView.adapter = ParkAdapter(it)
        })
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }
}