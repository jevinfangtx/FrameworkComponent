package com.tencent.component.nestscroll

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tencent.component.R
import com.tencent.component.R.id.recycler_view

class NestScrollFragment: Fragment() {

    lateinit var mAdapter: RecyclerView.Adapter<ViewHolder>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_nestscroll, container, false)
        mAdapter = RecyclerAdapter()
        recycler_view
        return view
    }
}


class RecyclerAdapter: RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(p0)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {


    }
}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

}