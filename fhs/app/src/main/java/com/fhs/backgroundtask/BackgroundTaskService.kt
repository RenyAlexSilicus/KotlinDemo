package com.fhs.backgroundtask

import android.app.job.JobParameters
import android.app.job.JobService


/**
 * Created by Ganesh Tikone on 21/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: BackgroundTaskService Job Service
 */
class BackgroundTaskService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {


//        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.ENGLISH)
//        val currentDate = sdf.format(Date())
//        val log = "Internet Available , Background Service Started at: $currentDate"

        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {

        return false
    }


}