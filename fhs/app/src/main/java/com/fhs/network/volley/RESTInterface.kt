package com.sysanenet.filmystan.network

import org.json.JSONObject

/**
 * Created by ganeshtikone on 20/3/18.
 * Interface : REST Executor Interface
 * Callback interface for RESTExecutor class
 * delegate result to UI thread on Activity/Fragment.
 *
 */
interface RESTInterface {

    fun onSuccess(requestCode:Int, data:JSONObject?, error: String?)
}