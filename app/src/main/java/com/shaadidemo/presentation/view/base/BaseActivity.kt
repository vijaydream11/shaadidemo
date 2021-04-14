package com.shaadidemo.view.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract val layoutId: Int
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        init()
    }

    abstract fun init()

    fun initLoader(message: String, title: String, isCancelable: Boolean) {

        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
        }

        progressDialog?.let {
            if(it.isShowing){
                it.setMessage(message)
                it.setCancelable(isCancelable)
                it.setTitle(title)
                it.show()
            }
        }
    }

    fun finishLoader() {
        if (progressDialog != null && progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        finishLoader()
    }
}
