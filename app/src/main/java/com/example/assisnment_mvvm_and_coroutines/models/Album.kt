package com.example.assisnment_mvvm_and_coroutines.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Album {
    @SerializedName("photos")
    @Expose
    var photo: Photo? = null

    @SerializedName("stat")
    @Expose
    var stat: String? = null
}