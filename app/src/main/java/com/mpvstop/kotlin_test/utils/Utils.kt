package com.mpvstop.kotlin_test.utils

import android.app.Activity
import android.content.Context
import javax.inject.Inject
class Utils @Inject constructor(val context: Context) {

    fun showSnackbar(context: Activity, message: String) {
//        val snackbar = Snackbar.make(
//            context.findViewById<TextView>(android.R.id.content), message,
//            Snackbar.LENGTH_LONG
//        )
//        val view = snackbar.getView()
//        val layoutParams = view.getLayoutParams() as FrameLayout.LayoutParams
//        layoutParams.gravity = Gravity.TOP
//        view.setLayoutParams(layoutParams)
//        view.setBackgroundColor(Color.WHITE)
//
//        val textView = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
//        textView.setTextColor(context.resources.getColor(R.color.navIconColor))
//        snackbar.show()
    }
}