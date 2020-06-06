package com.example.skeletondaggerapp.core.repository


import com.example.skeletondaggerapp.core.network.AppService
import com.example.skeletondaggerapp.db.DemoRoomObjectModel
import com.example.skeletondaggerapp.db.dao.DemoDAO
import com.example.skeletondaggerapp.model.DemoObjectPOJO
import com.example.skeletondaggerapp.utils.appID
import com.example.skeletondaggerapp.utils.baseUnit
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceRepository @Inject constructor(
    val appService: AppService,
    val demoDAO: DemoDAO
) : IWeatherRepository, ILocalStorageRepository {

    override fun getWeatherDataByCityName(cityName: String): Observable<DemoObjectPOJO> {
        return appService.getWeatherByCityName(cityName, appID, baseUnit)
    }

    override fun getWeatherDataByLatLong(
        latitude: String,
        longitude: String
    ): Observable<DemoObjectPOJO> {
        return appService.getWeatherByLatLong(latitude, longitude, appID, baseUnit)
    }

    override fun getWeatherForecastDataByCityName(cityName: String): Observable<DemoObjectPOJO> {
        return appService.getWeatherForecastByCityName(cityName, appID, baseUnit)
    }

    override fun getWeatherForecastDataByLatLong(
        latitude: String,
        longitude: String
    ): Observable<DemoObjectPOJO> {
        return appService.getWeatherForecastByLatLong(latitude, longitude, appID, baseUnit)
    }

    override fun getAllLocallyStoredWeatherData(): Single<List<DemoRoomObjectModel>> {
        return demoDAO.getAllData()
    }

    override fun insertWeatherDataIntoLocalStorage(model: DemoRoomObjectModel) {
        demoDAO.insert(model)
    }
}