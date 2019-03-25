package com.tencent.component.kotlindev

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tencent.component.R

class UserFragment: Fragment() {

    override
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_user_kotlin, container, false)
        var textView = view.findViewById<TextView>(R.id.text)
        val a:Int = 3
        textView.setText("a is $a")
        return view
    }

}