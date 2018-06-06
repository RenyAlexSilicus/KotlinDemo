package com.fhs.core

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView


/**
 * Created by Ganesh Tikone on 15/5/18.
 * Company: Silicus Technologies Pvt. Ltd.
 * Email: ganesh.tikone@silicus.com
 * Class: BaseActivity
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    /**
     * Activity object
     */
    lateinit var activity: AppCompatActivity

    /**
     * Logger
     */
    val logger: Logger = Logger.getInstance()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        activity = this
    }


    /**
     * Show Error SnackBar with error message and action
     * @param layout: CoordinatorLayout
     * @param error: String error message
     * @param action : Action shown on error snackBar
     *
     */
    fun showErrorSnackBar(layout: CoordinatorLayout, error: String, action: String) {
        val errorSnackBar = Snackbar.make(layout, error, Snackbar.LENGTH_INDEFINITE)
        errorSnackBar.view.setBackgroundColor(Color.parseColor("FFC107"))
        errorSnackBar.setActionTextColor(Color.parseColor("#00796B"))

        val actionTextView = errorSnackBar.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        actionTextView.setTextColor(Color.WHITE)

        errorSnackBar.show()
    }


    /**
     * Show  SnackBar with error message and action
     * @param layout: CoordinatorLayout
     * @param message: String error message
     *
     */
    fun showSuccessSnackBar(layout: CoordinatorLayout, message: String) {
        val snackBar = Snackbar.make(layout, message, Snackbar.LENGTH_SHORT)
        snackBar.view.setBackgroundColor(Color.parseColor("FFC107"))
        snackBar.show()
    }

}