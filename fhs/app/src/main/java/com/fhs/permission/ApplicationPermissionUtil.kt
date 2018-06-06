package com.fhs.permission

import android.Manifest
import android.app.Activity


/**
 * Created by Ganesh Tikone on 21/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: ApplicationPermissionUtil Singletone class
 *
 * Write function in one class to request for RunTime permission.
 * Permission Utility class for Marshmallow (API level 23) and above
 */
object ApplicationPermissionUtil {

    val WRITE_SD_REQ_CODE = 201

    val CAMERA_REQUEST_CODE = 202

    /**
     *  Request permission to write external storage
     * @param activity Activity object
     * @param callback PermissionUtil.ReqPermissionCallback object
     */
    fun checkWriteSD(activity: Activity, callback: PermissionUtil.ReqPermissionCallback) {

        PermissionUtil.checkPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                WRITE_SD_REQ_CODE,
                "We need write external storage permission to save your location to file",
                "We can't save your location to file without storage permission",
                callback)
    }

    /**
     * Request permission for access camera
     * @param activity Activity object
     * @param callback PermissionUtil.ReqPermissionCallback object
     */
    fun checkCamera(activity: Activity, callback: PermissionUtil.ReqPermissionCallback) {

        PermissionUtil.checkPermission(activity,
                Manifest.permission.CAMERA,
                CAMERA_REQUEST_CODE,
                "We need write external storage permission to save your location to file",
                "We can't save your location to file without storage permission",
                callback)
    }
}