package com.example.assisnment_mvvm_and_coroutines.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Photos {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("owner")
    @Expose
    var owner: String? = null

    @SerializedName("secret")
    @Expose
    var secret: String? = null

    @SerializedName("server")
    @Expose
    var server: String? = null

    @SerializedName("farm")
    @Expose
    var farm: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("ispublic")
    @Expose
    var ispublic: Int? = null

    @SerializedName("isfriend")
    @Expose
    var isfriend: Int? = null

    @SerializedName("isfamily")
    @Expose
    var isfamily: Int? = null

    @SerializedName("url_q")
    @Expose
    var urlQ: String? = null

    @SerializedName("height_q")
    @Expose
    var heightQ: Int? = null

    @SerializedName("width_q")
    @Expose
    var widthQ: Int? = null
}