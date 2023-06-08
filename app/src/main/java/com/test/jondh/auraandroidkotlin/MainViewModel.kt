package com.test.jondh.auraandroidkotlin

import androidx.lifecycle.ViewModel
import com.test.jondh.auraandroidkotlin.network.APIHelper
import com.test.jondh.auraandroidkotlin.network.PicsumInfo

class MainViewModel(
    private val apiHelper: APIHelper,
    private val listener: Listener
): ViewModel() {

    private var isLoading = false
    private var page = 0

    var photos = mutableListOf<PicsumInfo>()
        private set

    fun fetchPhotos() {
        if (isLoading) {
            return
        }

        page++
        isLoading = true
        apiHelper.getList(
            page = page,
            listener = {
                isLoading = false
                photos += it
                listener.photosReceived()
            },
            errorListener = {
                // TODO: Deal with errors
                isLoading = false
            })
    }

    interface Listener {
        fun photosReceived()
    }
}
