package com.fhs.core

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: VolleySingleton (Application Class)
 * If planning for Volley library then use this singletone class
 * to initialise volley library
 * Use this class to initialise
 * 1. Logger
 * 2. FCM
 * 3. Mobile Analytics framework
 *
 */
class VolleySingleton : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(this)
            }

            return field
        }

    fun <T> addRequestToQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }

    companion object {
        private val TAG = VolleySingleton::class.java.simpleName
        @get: Synchronized
        var instance: VolleySingleton? = null
            private set
    }
}