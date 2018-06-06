package com.fhs.feature.splash

import com.fhs.core.BasePresenter
import com.fhs.core.BaseViewOperation


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * interface: SplashMVPContract
 */
interface SplashMVPContract {

    /**
     * Implement interface SplashActivity / Fragment
     */
    interface ViewCallBackOperation : BaseViewOperation {
        fun afterDidSomething()
    }

    /**
     * Implemented at SplashPresenter
     */
    interface PresenterOperation : BasePresenter {
        fun doSomething()

        fun schduleSyncBackgroundWork()
    }


    /**
     * Implemented at SplashModel Class
     */
    interface ModelOperations {

        fun onDestroy()
    }

    /**
     * Implemented at SplashPresenter Class
     */
    interface ModelCallBackOperation {

        fun onWorkCompleted()
    }

}