package com.fhs.feature.splash


/**
 * Created by Ganesh Tikone on 21/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class:
 */
class SplashModel(presenter: SplashPresenter) : SplashMVPContract.ModelOperations {

    val mPresenter:SplashPresenter = presenter


    override fun onDestroy() {
        // destroy model
    }
}