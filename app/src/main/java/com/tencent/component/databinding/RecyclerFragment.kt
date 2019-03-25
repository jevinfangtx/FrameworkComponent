package com.tencent.component.databinding

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tencent.component.R

class RecyclerFragment: Fragment() {

    companion object {
        const val text1 = "分手的距离开发商的发生的纠纷克鲁赛德分手的距离开发商的减肥了开始的健康"
        const val text = "分手的距离开发商的发生的纠纷克鲁赛德分手的距离开发商的减肥了开始的健康"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        view.findViewById<TextView>(R.id.fragment_text).text = text
        val adapter = Adapter(context!!)
        adapter.init()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
}

class Adapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    private var mData = mutableListOf<Int>()

    fun init() {
        mData.clear()
        for (i in 0..10) {
            mData.add(i)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, p0, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val itemView = p0.itemView
        itemView.findViewById<TextView>(R.id.text).text = RecyclerFragment.text
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

}