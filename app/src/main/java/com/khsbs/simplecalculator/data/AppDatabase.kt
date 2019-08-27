package com.khsbs.simplecalculator.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.khsbs.simplecalculator.base.BaseApplication
import com.khsbs.simplecalculator.entity.History

@Database(
    entities = [History::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun get(): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        BaseApplication.appContext, AppDatabase::class.java, "history.db"
                    )/*.addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            val executor = Executors.newSingleThreadExecutor()
                            executor.execute(get().historyDao().deleteAll())
                        }
                    })*/
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE!!
        }
    }
}