package com.khsbs.simplecalculator.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.khsbs.simplecalculator.data.AppDatabase
import com.khsbs.simplecalculator.entity.History
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

class HistoryViewModel : ViewModel() {

    private val dao = AppDatabase.get().historyDao()

    fun getList() : LiveData<List<History>> = dao.getList()

    fun save(item: History) =
        Completable.fromCallable {
            dao.insert(item)
        }
            .subscribeOn(Schedulers.io())
}