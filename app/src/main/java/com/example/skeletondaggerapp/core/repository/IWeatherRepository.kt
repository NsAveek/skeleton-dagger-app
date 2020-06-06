package com.example.skeletondaggerapp.core.repository

import com.example.skeletondaggerapp.model.DemoObjectPOJO
import io.reactivex.Observable

interface IWeatherRepository {
    fun getWeatherDataByCityName(cityName : String) : Observable<DemoObjectPOJO>
    fun getWeatherDataByLatLong(latitude : String, longitude : String) : Observable<DemoObjectPOJO>
    fun getWeatherForecastDataByCityName(cityName : String) : Observable<DemoObjectPOJO>
    fun getWeatherForecastDataByLatLong(latitude : String, longitude : String) : Observable<DemoObjectPOJO>
}