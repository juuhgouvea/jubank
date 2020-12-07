package com.juuhgouvea.jubank.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "records")
data class Record(
    @ColumnInfo(name = "user_id") var userId: Long,
    var value: Float,
    var person: String,
    var remarks: String,
    @ColumnInfo(name = "registered_at") var registeredAt: Date
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}