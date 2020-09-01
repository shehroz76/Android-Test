package com.mpvstop.kotlin_test.core.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewModel> : DaggerFragment() {

    private var viewModel: T? = null
    private lateinit var mProgressDialog: ProgressDialog

    /**
     * @return view model instance
     */
    abstract fun getViewModel(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = if (viewModel == null) getViewModel() else viewModel
        mProgressDialog = ProgressDialog(activity)
    }

    fun showProgressDialog() {
        mProgressDialog?.show()
    }

    fun hideProgressDialog() {
        mProgressDialog?.dismiss()
    }

}