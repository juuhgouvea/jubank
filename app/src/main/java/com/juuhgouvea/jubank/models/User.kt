package com.juuhgouvea.jubank.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    var username: String,
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}