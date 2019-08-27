package com.khsbs.simplecalculator.util

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.script.ScriptEngineManager

object Calculate {

    private val engine = ScriptEngineManager().getEngineByName("js")

    /*fun eval(str: String): String {
        val engine = ScriptEngineManager().getEngineByName("js")
        try {
            val result = engine.eval(str) as Double
            return if (result % 1 == 0.0)
                result.toInt().toString() // 정수형으로 표현이 가능하다면 Int로 변환해 소수점 제거
            else
                result.toString()
        } catch (e: Exception) {
            return "수식이 올바르지 않습니다!"
        }
    }*/

    fun eval(str: String) =
        Single.fromCallable {
            engine.eval(str) as Double
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}