package com.khsbs.simplecalculator.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khsbs.simplecalculator.entity.History

class HistoryViewModel : ViewModel() {

    private val _items = MutableLiveData<List<History>>()

    val items: LiveData<List<History>> get() = _items
}