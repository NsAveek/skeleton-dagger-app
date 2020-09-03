package com.example.skeletondaggerapp.ui.home

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skeletondaggerapp.core.repository.RemoteDataSourceRepository
import com.example.skeletondaggerapp.db.DemoRoomObjectModel
import com.example.skeletondaggerapp.utils.CustomEventLiveData
import com.example.skeletondaggerapp.utils.EnumDataState
import com.example.skeletondaggerapp.utils.PairLocal
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(
    private val remoteDataSourceRepository: RemoteDataSourceRepository,
    private val appContext: Application
) :
    ViewModel() {

    /**
     * Live Data of message to emit for the server request
     **/
    private var _typedText: MutableLiveData<String> = MutableLiveData()

    /**
     * Live Data noConnectionLayoutVisbility to control visibility of no connection layout to the user
     **/
    val noConnectionLayoutVisibility = ObservableBoolean(false)

    val typedText: MutableLiveData<String>
        get() = _typedText


    fun insertDataInsideDB(model: DemoRoomObjectModel) {
        remoteDataSourceRepository.insertWeatherDataIntoLocalStorage(model)
    }

    fun getAllLocallyStoredData(): MutableLiveData<PairLocal<String, Any>> {
        val data = MutableLiveData<PairLocal<String, Any>>()
        remoteDataSourceRepository.getAllLocallyStoredWeatherData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.value = PairLocal(EnumDataState.SUCCESS.type, it)
            }, {
                data.value = PairLocal(EnumDataState.ERROR.type, it)
            })
        return data
    }
}