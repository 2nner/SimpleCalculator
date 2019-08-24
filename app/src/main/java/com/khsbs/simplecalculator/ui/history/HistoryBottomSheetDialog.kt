package com.khsbs.simplecalculator.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.khsbs.simplecalculator.R

class HistoryBottomSheetDialog : BottomSheetDialogFragment() {

    private val viewmodel: HistoryViewModel by lazy {
        ViewModelProviders.of(parentFragment!!).get(HistoryViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bsd_history, container)
    }
}