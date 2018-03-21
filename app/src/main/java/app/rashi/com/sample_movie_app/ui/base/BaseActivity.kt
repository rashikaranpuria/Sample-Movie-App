package app.rashi.com.sample_movie_app.ui.base

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.toast

open class BaseActivity : AppCompatActivity(), IBaseView {

    open lateinit var mProgressDialog: ProgressDialog

    override fun showProgressBar() {
        mProgressDialog.show()
    }

    override fun hideProgressDialog() {
        mProgressDialog.hide()
    }

    override fun showError(errorStr: String) {
        toast(errorStr)
    }
}