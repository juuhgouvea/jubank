package com.juuhgouvea.jubank.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juuhgouvea.jubank.models.Record

@Dao
interface RecordDAO {
    @Query("select * from records where user_id = :userId")
    fun getAll(userId: Long): List<Record>

    @Insert
    fun insert(record: Record): Long
}