package com.khsbs.simplecalculator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khsbs.simplecalculator.util.Calculate

class MainViewModel : ViewModel() {

    private val _expr = MutableLiveData<String>()
    private val _result = MutableLiveData<String>()

    // For Immutable
    val expr: LiveData<String> get() = _expr
    val result: LiveData<String> get() = _result

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
        _result.value = Calculate.eval(expr)
    }

    fun eraseExpr() {
        if (_expr.value.isNullOrBlank().not()) {
            _expr.value = _expr.value?.dropLast(1)
        }
    }
}