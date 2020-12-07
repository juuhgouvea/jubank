package com.juuhgouvea.jubank.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.juuhgouvea.jubank.database.daos.RecordDAO
import com.juuhgouvea.jubank.database.daos.UserDAO
import com.juuhgouvea.jubank.models.Record
import com.juuhgouvea.jubank.models.User

@Database(entities = [User::class, Record::class], version = 1)
@TypeConverters(Converters::class)
abstract  class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun recordDao(): RecordDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val currentInstance = INSTANCE

            if(currentInstance !== null)
                return currentInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "jubank-db"
                )
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance

                return instance
            }
        }
    }
}