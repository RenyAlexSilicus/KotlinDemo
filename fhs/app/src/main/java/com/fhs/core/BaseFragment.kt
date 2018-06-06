package com.fhs.core

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.view.View


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: BaseFragment
 */
open class BaseFragment : Fragment() {

    /**
     * FHS Base Activity
     */
    protected lateinit var activity: BaseActivity

    /**
     * FHSApplication instance
     */
    protected lateinit var application: FHSApplication

    /**
     * Logger
     */
    protected lateinit var logger: Logger


    /**
     *  Root View Object
     */
    protected lateinit var rootView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as BaseActivity
        application = activity.application as FHSApplication
        logger = Logger.getInstance()
    }

    /**
     * Show Error SnackBar with error message and action
     * @param layout: CoordinatorLayout
     * @param error: String error message
     * @param action : Action shown on error snackBar
     *
     */
    protected fun showErrorSnackBar(layout: CoordinatorLayout, error: String, action: String) {
        activity.showErrorSnackBar(layout, error, action)
    }

    /**
     * Show  SnackBar with error message and action
     * @param layout: CoordinatorLayout
     * @param message: String error message
     *
     */
    protected fun showSuccessSnackBar(layout: CoordinatorLayout, message: String) {
        activity.showSuccessSnackBar(layout, message)
    }
}