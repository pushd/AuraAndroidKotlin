package com.test.jondh.auraandroidkotlin.network

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.jondh.auraandroidkotlin.SingletonHolder
import java.util.*

class APIHelper private constructor(context: Context) {
    private var queue: RequestQueue? = null

    init {
        queue = Volley.newRequestQueue(context)
    }

    companion object : SingletonHolder<APIHelper, Context>(::APIHelper)

    fun getImageInfo(
        imageId: String?,
        listener: Response.Listener<PicsumInfo>,
        errorListener: Response.ErrorListener
    ) {
        val url = String.format(
            Locale.getDefault(),
            "https://picsum.photos/id/%s/info",
            imageId
        )
        val gson = Gson()
        val simpleVolleyRequest: SimpleVolleyRequest<PicsumInfo> =
            object : SimpleVolleyRequest<PicsumInfo>(url, null, listener, errorListener) {
                override fun get(json: String): PicsumInfo {
                    return gson.fromJson(json, PicsumInfo::class.java)
                }
            }
        queue!!.add(simpleVolleyRequest)
    }

    fun getList(
        listener: Response.Listener<List<PicsumInfo>>,
        errorListener: Response.ErrorListener
    ) {
        val url = "https://picsum.photos/v2/list"
        val gson = Gson()
        val simpleVolleyRequest: SimpleVolleyRequest<List<PicsumInfo>> = object :
            SimpleVolleyRequest<List<PicsumInfo>>(
                url,
                null,
                listener,
                errorListener
            ) {
            override fun get(json: String): List<PicsumInfo> {
                val collectionType =
                    object : TypeToken<List<PicsumInfo>>() {}.type
                return gson.fromJson<List<PicsumInfo>>(json, collectionType)
            }
        }
        queue!!.add(simpleVolleyRequest)
    }
}