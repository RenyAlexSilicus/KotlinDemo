package com.fhs.core

import android.util.Log


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: Logger, Log information using this
 */
class Logger private constructor() {


    /**
     * Static
     */
    companion object {
        /**
         * debuggable object
         */
        var debuggable: Boolean = false

        /**
         * Logger object
         */
        var logger: Logger? = null

        /**
         * Get Instance function
         */
        fun getInstance():Logger {
            if (null == logger) {
                logger = Logger()
            }

            return logger!!
        }
    }


    /**
     * Debug log
     */
    fun debug(tag: String, message: String) {
        if (debuggable)
            Log.d(tag, message)
    }

    /**
     * Verbose log
     */
    fun verbose(tag: String, message: String) {
        if (debuggable)
            Log.v(tag, message)
    }

    /**
     * Info log
     */
    fun info(tag: String, message: String) {
        if (debuggable)
            Log.i(tag, message)
    }

    /**
     * Error log
     */
    fun error(tag: String, message: String) {
        if (debuggable)
            Log.e(tag, message)
    }

    /**
     * Debug log
     */
    fun warning(tag: String, message: String) {
        if (debuggable)
            Log.w(tag, message)
    }

    /**
     * Set debuggable
     */
    fun setDebuggable(flag: Boolean) {
        debuggable = flag
    }

}