package com.example.skeletondaggerapp.core.network;

import com.example.skeletondaggerapp.model.DemoObjectPOJO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AppService {


    @GET("weather")
    Observable<DemoObjectPOJO> getWeatherByCityName(@Query("q") String cityName,
                                                    @Query("APPID") String appID,
                                                    @Query("units") String units);
    @GET("weather")
    Observable<DemoObjectPOJO> getWeatherByLatLong(@Query("lat") String latitude,
                                                   @Query("lon") String longitude,
                                                   @Query("APPID") String appID,
                                                   @Query("units") String units);
    @GET("forecast")
    Observable<DemoObjectPOJO> getWeatherForecastByCityName(@Query("q") String cityName,
                                                            @Query("APPID") String appID,
                                                            @Query("units") String units);
    @GET("forecast")
    Observable<DemoObjectPOJO> getWeatherForecastByLatLong(@Query("lat") String latitude,
                                                           @Query("lon") String longitude,
                                                           @Query("APPID") String appID,
                                                           @Query("units") String units);


}
