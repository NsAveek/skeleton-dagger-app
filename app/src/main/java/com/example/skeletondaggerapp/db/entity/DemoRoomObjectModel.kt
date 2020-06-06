package com.example.skeletondaggerapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class DemoRoomObjectModel (
        @PrimaryKey var uid : String,
        @ColumnInfo(name = "name") var name : String?,
        @Ignore var type : String? = null
){
    constructor():this("","","")
}

