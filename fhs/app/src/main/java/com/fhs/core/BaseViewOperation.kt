package com.fhs.core

import android.content.Context


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * interface: BaseViewOperation
 */
interface BaseViewOperation {

    fun getActivityContext(): Context

    fun getAppContext(): Context
}