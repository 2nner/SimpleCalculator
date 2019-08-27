package com.khsbs.simplecalculator.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.khsbs.simplecalculator.R
import com.khsbs.simplecalculator.databinding.ActivityMainBinding
import com.khsbs.simplecalculator.ui.history.HistoryBottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        with (binding) {
            mainViewModel = viewModel
            lifecycleOwner = this@MainActivity
        }

        tv_expr.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tv_result.visibility = View.INVISIBLE
            }
        })

        observeData()
    }

    fun observeData() {
        viewModel.history.observe(this, Observer {
            HistoryBottomSheetDialog().show(supportFragmentManager, "HistoryBottomSheetDialog")
        })
    }
}
