package android.rashi.com.sample_movie_app.ui.base

open class BasePresenter<V: IBaseView>: IBasePresenter<V>  {

    var view: V? = null

    override fun onAttach(v: V) {
        view = v
    }

    override fun onDetach() {
        view = null
    }
}