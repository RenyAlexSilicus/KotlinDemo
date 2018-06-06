package com.fhs.backgroundtask

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import com.fhs.core.Logger


/**
 * Created by Ganesh Tikone on 21/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: BackgroundTaskBuilder
 */
class BackgroundTaskBuilder(context: Context) {

    /**
     *
     */
    private val mContext = context

    /**
     *
     */
    private val JOBID: Int = 9001

    fun buildAndSchedulerJobService() {

        val jobInfo = buildJobInfo()
        scheduleJobWith(jobInfo)
    }

    private fun scheduleJobWith(jobInfo: JobInfo) {

        val jobScheduler = mContext.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val scheduleResult = jobScheduler.schedule(jobInfo)

        if (JobScheduler.RESULT_SUCCESS == scheduleResult) {
            Logger.getInstance().error("BackgroundTaskBuilder","Job Schedule Done")
        }
    }


    private fun buildJobInfo(): JobInfo {

        val componentName = ComponentName(mContext, BackgroundTaskService::class.java)


        return JobInfo.Builder(JOBID, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                .setPeriodic(60000)
                //.setPeriodic(1800000)
                .build()
    }
}