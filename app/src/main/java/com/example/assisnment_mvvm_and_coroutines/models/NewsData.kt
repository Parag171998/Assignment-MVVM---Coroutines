package com.example.assisnment_mvvm_and_coroutines.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsData {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null

    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null
}