package com.example.assisnment_mvvm_and_coroutines.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherInfo {
    @SerializedName("location")
    @Expose
    var location: Location? = null

    @SerializedName("current")
    @Expose
    var current: Current? = null
}