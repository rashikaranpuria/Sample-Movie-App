package android.rashi.com.sample_movie_app.ui.main

import android.rashi.com.sample_movie_app.ui.base.IBaseView

interface IMainActivityView: IBaseView {
    fun showProgressBar()
    fun hideProgressDialog()
    fun showError(errorStr: String)
}