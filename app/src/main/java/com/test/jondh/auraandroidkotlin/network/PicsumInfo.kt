package com.test.jondh.auraandroidkotlin.network

class PicsumInfo {
    private val id: String? = null
    private val author: String? = null
    private val width = 0
    private val height = 0
    private val url: String? = null
    private val download_url: String? = null

    fun getId(): String? {
        return id
    }

    fun getAuthor(): String? {
        return author
    }

    fun getWidth(): Int {
        return width
    }

    fun getHeight(): Int {
        return height
    }

    fun getUrl(): String? {
        return url
    }

    fun getDownloadUrl(): String? {
        return download_url
    }

    override fun toString(): String {
        return "PicsumInfo(id=$id, author=$author, width=$width, height=$height, url=$url, download_url=$download_url)"
    }
}