package com.example.skeletondaggerapp.core.repository

import com.example.skeletondaggerapp.db.DemoRoomObjectModel
import io.reactivex.Single

interface ILocalStorageRepository {
    fun getAllLocallyStoredWeatherData() : Single<List<DemoRoomObjectModel>>
    fun insertWeatherDataIntoLocalStorage(model : DemoRoomObjectModel)
}