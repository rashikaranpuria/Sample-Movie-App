package app.rashi.com.sample_movie_app.ui.base

interface IBaseView {
    fun showProgressBar()
    fun hideProgressDialog()
    fun showError(errorStr: String)
}