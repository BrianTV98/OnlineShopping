package com.example.onlineshopping.ui.base

import android.app.AlertDialog
import android.content.Context
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.example.onlineshopping.utils.DialogUtils
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), IBase {

    var loadingDialog: AlertDialog? = null

    open fun enableOutSideClickHideKeyboard(): Boolean = false

    override fun showLoading() {
        loadingDialog = DialogUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        loadingDialog?.dismiss()
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun hideKeyboard() {
        currentFocus?.let {
            val inputMethodManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        val view = currentFocus
        val ret = super.dispatchTouchEvent(event)

        if (view is EditText) {
            val w = currentFocus
            val scrcoords = IntArray(2)
            w!!.getLocationOnScreen(scrcoords)
            val x = event.rawX + w.left - scrcoords[0]
            val y = event.rawY + w.top - scrcoords[1]

            if (event.action == MotionEvent.ACTION_UP &&
                (x < w.left || x >= w.right || y < w.top || y > w.bottom) &&
                enableOutSideClickHideKeyboard()
            ) {
                hideKeyboard()
            }
        }
        return ret
    }

}
