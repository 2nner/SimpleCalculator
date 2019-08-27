package com.khsbs.simplecalculator.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khsbs.simplecalculator.data.AppDatabase
import com.khsbs.simplecalculator.entity.History
import com.khsbs.simplecalculator.util.Calculate
import com.khsbs.simplecalculator.util.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.plusAssign

class MainViewModel : ViewModel() {

    private val _expr = MutableLiveData<String>()
    private val _result = MutableLiveData<String>()
    private val _history = SingleLiveEvent<Any>()

    // For Immutable
    val expr: LiveData<String> get() = _expr
    val result: LiveData<String> get() = _result
    val history: LiveData<Any> get() = _history

    private val dao = AppDatabase.get().historyDao()
    private val cd = CompositeDisposable()

    init {
        _expr.value = ""
        _result.value = ""
    }

    fun clickNumPad(c: Char) {
        _expr.value += c
    }

    fun resetExpr() {
        _expr.value = ""
        _result.value = ""
    }

    fun calculate(expr: String) {
        // _result.value = Calculate.eval(expr)

        cd += Calculate.eval(expr)
            .subscribeWith(object : DisposableSingleObserver<Double>() {
                override fun onSuccess(t: Double) {
                    if (t % 1 == 0.0)
                        _result.value = t.toInt().toString()
                    else
                        _result.value = t.toString()
                    dao.insert(History(0, expr, _result.value!!))
                }

                override fun onError(e: Throwable) {
                    _result.value = "올바른 수식이 아닙니다!"
                }
            })
    }

    fun eraseExpr() {
        if (_expr.value.isNullOrBlank().not()) {
            _expr.value = _expr.value?.dropLast(1)
        }
    }

    fun showHistory() = _history.call()

    override fun onCleared() {
        super.onCleared()
        cd.clear()
    }
}