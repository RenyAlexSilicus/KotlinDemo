package com.sysanenet.filmystan.network

import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.fhs.core.VolleySingleton

import org.json.JSONObject

/**
 * Created by ganeshtikone on 20/3/18.
 * Class: RESTExecutor
 *
 * Execute JsonObject/JsonArray/String request from RESTExecutor class
 *
 */

class RESTExecutor(requestCode: Int, requestMethod: Int, requestURL: String) {

    private var requestMethod: Int? = null

    init {
        this.requestMethod = requestMethod
    }

    private var requestCode: Int? = null

    init {
        this.requestCode = requestCode
    }

    private var requestURL: String? = null

    init {
        this.requestURL = requestURL
    }

    private var listener: RESTInterface? = null

    /**
     * Listener
     */
    fun setListener(listener: RESTInterface) {
        this.listener = listener
    }


    /**
     * Build JSON Object Request
     */
    fun buildJsonObjectRequest() {

        val jsonObjectRequest = object : JsonObjectRequest(requestMethod!!, requestURL, null,
                Response.Listener<JSONObject> { response ->
                    Log.d(TAG, response.toString())
                    listener?.onSuccess(requestCode!!, response, null)
                },
                Response.ErrorListener { error ->
                    //Log.e(TAG, error!!.localizedMessage)
                    listener?.onSuccess(requestCode!!, null, error.localizedMessage)
                }
        ) {

        }

        VolleySingleton.instance?.addRequestToQueue(jsonObjectRequest)
    }


    companion object {
        private val TAG = RESTExecutor::class.java.simpleName
    }

}