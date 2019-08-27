package com.khsbs.simplecalculator.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khsbs.simplecalculator.R
import com.khsbs.simplecalculator.entity.History
import kotlinx.android.synthetic.main.item_history.view.*

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    var items: List<History> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder =
        HistoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history, parent, false)
        )

    override fun onBindViewHolder(holder: HistoryViewHolder, pos: Int) {
        holder.bind(items[pos])
    }

    override fun getItemCount(): Int = items.size

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: History) {
            with(itemView) {
                tv_history_expr.text = item.expr
                tV_history_result.text = "= ".plus(item.result)
            }
        }
    }
}