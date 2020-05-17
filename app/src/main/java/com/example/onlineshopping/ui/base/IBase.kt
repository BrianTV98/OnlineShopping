package com.example.onlineshopping.ui.base

import androidx.annotation.StringRes

interface IBase {
    fun onBackPressed()
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String?)
    fun showMessage(@StringRes resId: Int)
    fun handleThrowable(errorCode: Int? = null, throwable: Throwable? = null)
    fun handleListener(eventType: Int)
    fun openActivityOnTokenExpire()
    fun hideKeyboard()

}
