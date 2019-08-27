package com.khsbs.simplecalculator.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khsbs.simplecalculator.entity.History

@Dao
interface HistoryDao {
    @Query("SELECT * FROM History")
    fun getList(): LiveData<List<History>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: History)
}