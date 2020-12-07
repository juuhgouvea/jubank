package com.juuhgouvea.jubank.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juuhgouvea.jubank.models.User

@Dao
interface UserDAO {
    @Query("select * from users where username = :username and password = :password")
    fun findByUsernameAndPassword(username: String, password: String): User;

    @Insert
    fun insert(user: User): Long
}