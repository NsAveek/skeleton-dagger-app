package com.example.skeletondaggerapp.db.dao
import androidx.room.Dao
import androidx.room.Query
import com.example.skeletondaggerapp.db.DemoRoomObjectModel
import io.reactivex.Single

@Dao
interface DemoDAO : BaseDAO<DemoRoomObjectModel> {

    @Query("SELECT * FROM `demoroomobjectmodel`")
    fun getAllData() : Single<List<DemoRoomObjectModel>>
}