package com.fhs.feature.splash

import android.os.Handler
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.fhs.core.Logger
import com.fhs.workmanager.SyncWorker
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: SplashPresenter for SplashActivity
 */
class SplashPresenter(logger: Logger, viewOperation: SplashMVPContract.ViewCallBackOperation) : SplashMVPContract.PresenterOperation, SplashMVPContract.ModelCallBackOperation {


    val tag = SplashPresenter::class.java.simpleName

    /**
     * Logger object
     */
    private val log = logger

    /**
     * Weak reference of view operation
     */
    var viewOperation: WeakReference<SplashMVPContract.ViewCallBackOperation>? = WeakReference(viewOperation)

    /**
     * Splash Model object
     */
    var model: SplashModel? = SplashModel(this@SplashPresenter)


    override fun doSomething() {
        log.debug(tag, "doSomething called")
        val handler = Handler()
        handler.postDelayed({
            viewOperation?.get()?.afterDidSomething()
        }, 1000)
    }

    override fun onDestroy() {
        viewOperation = null
        model = null
    }

    override fun onWorkCompleted() {
        // do some code here
    }

    override fun schduleSyncBackgroundWork() {

        val workManager = WorkManager.getInstance()

        val networkConstraint = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        val perodicWorkRequest = PeriodicWorkRequest.Builder(SyncWorker::class.java,
                5,
                TimeUnit.MINUTES,
                3,
                TimeUnit.MINUTES
        )
                .setConstraints(networkConstraint)
                .build()
        workManager.enqueue(perodicWorkRequest)
    }

}


