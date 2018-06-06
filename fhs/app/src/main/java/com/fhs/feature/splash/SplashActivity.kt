package com.fhs.feature.splash

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.fhs.R
import com.fhs.backgroundtask.BackgroundTaskBuilder
import com.fhs.camera.CameraActivity
import com.fhs.core.BaseActivity
import com.fhs.feature.splash.SplashMVPContract.ViewCallBackOperation
import com.fhs.permission.ApplicationPermissionUtil
import com.fhs.permission.PermissionUtil
import com.fhs.signature.SignatureActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(), ViewCallBackOperation, PermissionUtil.ReqPermissionCallback {

    /**
     * TAG
     */
    val tag: String = SplashActivity::class.java.simpleName

    /**
     * Presenter Operation
     */
    val presenterOperation = SplashPresenter(logger, this)

    private val signRequestCode: Int = 200


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        showToast("Hello Kotlin")
        scheduleBackgroundJob()
        setListener()
    }


    private fun setListener() {

        buttonCamera.setOnClickListener {
            val intent = Intent(this@SplashActivity, CameraActivity::class.java)
            startActivity(intent)
        }

        buttonSignature.setOnClickListener {
            val signatureIntent = Intent(this@SplashActivity, SignatureActivity::class.java)
            startActivityForResult(signatureIntent, signRequestCode)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == signRequestCode && resultCode == Activity.RESULT_OK) {
            val imagePath = data?.getStringExtra("signature")
            imageViewGT.loadImageFromPath(imagePath)
        }

    }


    private fun scheduleBackgroundJob() {
        val builder = BackgroundTaskBuilder(this@SplashActivity)
        builder.buildAndSchedulerJobService()

    }


    override fun onResume() {
        super.onResume()
        presenterOperation.doSomething()
        presenterOperation.schduleSyncBackgroundWork()
        getExternalSDCardPermission()
        getCameraAccess()

    }

    /**
     *
     */
    private fun getExternalSDCardPermission() {
        ApplicationPermissionUtil.checkWriteSD(this@SplashActivity, this)
    }

    private fun getCameraAccess() {
        ApplicationPermissionUtil.checkCamera(this@SplashActivity, this)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenterOperation.onDestroy()
    }


    /**
     * Show Toast function
     */
    fun SplashActivity.showToast(message: String) {
        Toast.makeText(this@SplashActivity, message, Toast.LENGTH_SHORT).show()
        logger.debug(tag, message)
    }

    /**
     * After Did Something Called
     */
    override fun afterDidSomething() {
        logger.warning(tag, "afterDidSomething called")
    }


    /**
     * return context
     */
    override fun getActivityContext(): Context {
        return this@SplashActivity
    }


    /**
     * return application context
     */
    override fun getAppContext(): Context {
        return applicationContext
    }

    /**
     *
     */
    override fun onResult(success: Boolean) {
        logger.error(tag, "Permission Granted")
    }


}
