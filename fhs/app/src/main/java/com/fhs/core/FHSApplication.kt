package com.fhs.core

import android.app.Application
import com.fhs.BuildConfig


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: Base Application class
 * Use this class to initialise
 * 1. Logger
 * 2. FCM
 * 3. Mobile Analytics framework

 */
class FHSApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialise logger based on application flavour
        Logger.getInstance().setDebuggable(BuildConfig.LOGDEBUG)
    }
}