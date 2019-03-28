package com.tencent.component.databinding

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tencent.component.R

class SpanFragment: Fragment() {

    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_span, container, false)
        val textView = view.findViewById<TextView>(R.id.textview)
        val text = "我怕的打好看的撒环境的按时的及哦啊的我怕的打好看的撒环境的按时的及哦啊的我怕的打好看的撒环境的按时的及哦啊的"
//        val span = UrlImageSpan(this.context, "http://shp.qpic.cn/wg_hpic/0/avatar_1511611390494/0", textView)
//        val builder = SpannableStringBuilder(text)
//        builder.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = text
        return view
    }
}