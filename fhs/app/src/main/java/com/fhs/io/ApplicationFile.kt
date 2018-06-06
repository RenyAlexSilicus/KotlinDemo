package com.fhs.io

import android.os.Environment
import java.io.File


/**
 * Created by Ganesh Tikone on 23/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: Application File operation class
 * This is Singletone in kotlin. Add File operation method
 * as per file operations are required
 *
 */
object ApplicationFile {

    /**
     * Get file object for storing images on sdcard/external storage
     * Path: /sdcard/fhs/.photo/  at which file get stored
     * @return File file object with random file name
     */
    fun getRandomPhotoFile(): File {

        val root = Environment.getExternalStorageDirectory()
        val photoDir = File("${root.absolutePath}/fhs/.photo")
        if (!photoDir.exists())
            photoDir.mkdirs()

        val currentTimeInMillis = System.currentTimeMillis()
        return File("${photoDir.absolutePath}/$currentTimeInMillis.jpg")
    }
}