package com.example.assisnment_mvvm_and_coroutines.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Album {
    @SerializedName("total")
    @Expose
    private var total: Int? = null

    @SerializedName("totalHits")
    @Expose
    private var totalHits: Int? = null

    @SerializedName("hits")
    @Expose
    private var hits: List<Hit?>? = null

    fun getTotal(): Int? {
        return total
    }

    fun setTotal(total: Int?) {
        this.total = total
    }

    fun getTotalHits(): Int? {
        return totalHits
    }

    fun setTotalHits(totalHits: Int?) {
        this.totalHits = totalHits
    }

    fun getHits(): List<Hit?>? {
        return hits
    }

    fun setHits(hits: List<Hit?>?) {
        this.hits = hits
    }
}