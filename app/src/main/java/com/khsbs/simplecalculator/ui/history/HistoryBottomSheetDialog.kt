package com.khsbs.simplecalculator.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.khsbs.simplecalculator.R
import kotlinx.android.synthetic.main.bsd_history.*

class HistoryBottomSheetDialog : BottomSheetDialogFragment() {

    private val viewmodel: HistoryViewModel by lazy {
        ViewModelProviders.of(activity!!).get(HistoryViewModel::class.java)
    }

    private val historyAdapter: HistoryAdapter by lazy {
        HistoryAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bsd_history, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_history.adapter = historyAdapter
        rv_history.layoutManager = LinearLayoutManager(activity)
        observeData()
    }

    fun observeData() {
        viewmodel.getList().observe(this, Observer {
            historyAdapter.items = it
        })
    }
}