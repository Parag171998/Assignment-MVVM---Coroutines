package com.example.assisnment_mvvm_and_coroutines.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hit {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("pageURL")
    @Expose
    private var pageURL: String? = null

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("tags")
    @Expose
    private var tags: String? = null

    @SerializedName("previewURL")
    @Expose
    private var previewURL: String? = null

    @SerializedName("previewWidth")
    @Expose
    private var previewWidth: Int? = null

    @SerializedName("previewHeight")
    @Expose
    private var previewHeight: Int? = null

    @SerializedName("webformatURL")
    @Expose
    private var webformatURL: String? = null

    @SerializedName("webformatWidth")
    @Expose
    private var webformatWidth: Int? = null

    @SerializedName("webformatHeight")
    @Expose
    private var webformatHeight: Int? = null

    @SerializedName("largeImageURL")
    @Expose
    private var largeImageURL: String? = null

    @SerializedName("imageWidth")
    @Expose
    private var imageWidth: Int? = null

    @SerializedName("imageHeight")
    @Expose
    private var imageHeight: Int? = null

    @SerializedName("imageSize")
    @Expose
    private var imageSize: Int? = null

    @SerializedName("views")
    @Expose
    private var views: Int? = null

    @SerializedName("downloads")
    @Expose
    private var downloads: Int? = null

    @SerializedName("collections")
    @Expose
    private var collections: Int? = null

    @SerializedName("likes")
    @Expose
    private var likes: Int? = null

    @SerializedName("comments")
    @Expose
    private var comments: Int? = null

    @SerializedName("user_id")
    @Expose
    private var userId: Int? = null

    @SerializedName("user")
    @Expose
    private var user: String? = null

    @SerializedName("userImageURL")
    @Expose
    private var userImageURL: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getPageURL(): String? {
        return pageURL
    }

    fun setPageURL(pageURL: String?) {
        this.pageURL = pageURL
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getTags(): String? {
        return tags
    }

    fun setTags(tags: String?) {
        this.tags = tags
    }

    fun getPreviewURL(): String? {
        return previewURL
    }

    fun setPreviewURL(previewURL: String?) {
        this.previewURL = previewURL
    }

    fun getPreviewWidth(): Int? {
        return previewWidth
    }

    fun setPreviewWidth(previewWidth: Int?) {
        this.previewWidth = previewWidth
    }

    fun getPreviewHeight(): Int? {
        return previewHeight
    }

    fun setPreviewHeight(previewHeight: Int?) {
        this.previewHeight = previewHeight
    }

    fun getWebformatURL(): String? {
        return webformatURL
    }

    fun setWebformatURL(webformatURL: String?) {
        this.webformatURL = webformatURL
    }

    fun getWebformatWidth(): Int? {
        return webformatWidth
    }

    fun setWebformatWidth(webformatWidth: Int?) {
        this.webformatWidth = webformatWidth
    }

    fun getWebformatHeight(): Int? {
        return webformatHeight
    }

    fun setWebformatHeight(webformatHeight: Int?) {
        this.webformatHeight = webformatHeight
    }

    fun getLargeImageURL(): String? {
        return largeImageURL
    }

    fun setLargeImageURL(largeImageURL: String?) {
        this.largeImageURL = largeImageURL
    }

    fun getImageWidth(): Int? {
        return imageWidth
    }

    fun setImageWidth(imageWidth: Int?) {
        this.imageWidth = imageWidth
    }

    fun getImageHeight(): Int? {
        return imageHeight
    }

    fun setImageHeight(imageHeight: Int?) {
        this.imageHeight = imageHeight
    }

    fun getImageSize(): Int? {
        return imageSize
    }

    fun setImageSize(imageSize: Int?) {
        this.imageSize = imageSize
    }

    fun getViews(): Int? {
        return views
    }

    fun setViews(views: Int?) {
        this.views = views
    }

    fun getDownloads(): Int? {
        return downloads
    }

    fun setDownloads(downloads: Int?) {
        this.downloads = downloads
    }

    fun getCollections(): Int? {
        return collections
    }

    fun setCollections(collections: Int?) {
        this.collections = collections
    }

    fun getLikes(): Int? {
        return likes
    }

    fun setLikes(likes: Int?) {
        this.likes = likes
    }

    fun getComments(): Int? {
        return comments
    }

    fun setComments(comments: Int?) {
        this.comments = comments
    }

    fun getUserId(): Int? {
        return userId
    }

    fun setUserId(userId: Int?) {
        this.userId = userId
    }

    fun getUser(): String? {
        return user
    }

    fun setUser(user: String?) {
        this.user = user
    }

    fun getUserImageURL(): String? {
        return userImageURL
    }

    fun setUserImageURL(userImageURL: String?) {
        this.userImageURL = userImageURL
    }
}